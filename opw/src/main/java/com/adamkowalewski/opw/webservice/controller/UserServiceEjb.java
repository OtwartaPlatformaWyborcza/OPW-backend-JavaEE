/*
 * The MIT License
 *
 * Copyright 2015 Adam Kowalewski.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.adamkowalewski.opw.webservice.controller;

import com.adamkowalewski.opw.bean.ConfigBean;
import com.adamkowalewski.opw.bean.MailBean;
import com.adamkowalewski.opw.bean.SessionBean;
import com.adamkowalewski.opw.bean.UserBean;
import com.adamkowalewski.opw.bean.WynikBean;
import com.adamkowalewski.opw.entity.OpwObwodowaKomisja;
import com.adamkowalewski.opw.entity.OpwSession;
import com.adamkowalewski.opw.entity.OpwUser;
import com.adamkowalewski.opw.view.OpwConfigStatic;
import com.adamkowalewski.opw.webservice.dto.GResultDto;
import com.adamkowalewski.opw.webservice.dto.KomisjaShortDto;
import com.adamkowalewski.opw.webservice.dto.UserDto;
import com.adamkowalewski.opw.webservice.dto.UserRegisterDto;
import com.adamkowalewski.opw.webservice.security.SecurityHandler;
import com.adamkowalewski.opw.webservice.security.SecurityObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.core.GenericEntity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static javax.ws.rs.core.Response.Status.*;

/**
 * @author Adam Kowalewski
 */
@Stateless
public class UserServiceEjb implements Serializable {
    
    private final static Logger logger = LoggerFactory.getLogger(UserServiceEjb.class);
    
    @EJB
    SecurityHandler securityHandler;
    @EJB
    UserBean userBean;
    @EJB
    WynikBean wynikBean;
    @EJB
    MailBean mailBean;
    @EJB
    ConfigBean configBean;
    @EJB
    SessionBean sessionBean;
    
    public UserServiceEjb() {
    }
    
    public GResultDto login(String login, String password) {
        
        OpwUser user = userBean.verifyCredentials(login, password, OpwConfigStatic.APP_SALT);

        // if auth failed 
        if (user == null) {
            logger.error("REST Login failed for {}.", login);
            return GResultDto.invalidResult(UNAUTHORIZED.getStatusCode());
        }
        // auth ok
        String restToken = userBean.encryptSHA(userBean.generatePassword());
        
        Date timeout = fetchExpireDate();
        
        OpwSession session = new OpwSession();
        session.setToken(restToken);
        session.setOpwUserId(user);
        session.setDateValidTo(timeout);
        session.setActive(true);
        sessionBean.create(session);
        
        UserDto userDto = new UserDto(
                user.getId(),
                user.getFirstname(),
                user.getLastname(),
                login,
                restToken,
                true,
                String.valueOf(timeout.getTime())
        );
        return GResultDto.validResult(OK.getStatusCode(), userDto);
    }
    
    private Date fetchExpireDate() {
        int timeoutInSeconds = Integer.valueOf(configBean.readConfigValue(OpwConfigStatic.REST_SESSION_TIMEOUT_IN_SECONDS));
        Calendar timeout = Calendar.getInstance();
        timeout.add(Calendar.SECOND, timeoutInSeconds);
        return timeout.getTime();
    }

    /**
     * Logout REST user.
     *
     * @param login used for authentication.
     * @param token used for authentication.
     * @return <code>200</code> when logged out, otherwise <code>401</code>.
     * @author Adam Kowalewski
     * @version 2015.05.08
     */
    public GResultDto logout(String login, String token) {
        if (!securityHandler.checkUser(login, token)) {            
            return GResultDto.invalidResult(UNAUTHORIZED.getStatusCode());
        }
        logger.trace("logout user {} token {}", login, token);
        OpwUser user = userBean.findUser(login);
        OpwSession session = sessionBean.find(user, token);
        session.setActive(false);
        sessionBean.edit(session);
        
        return GResultDto.validResult(OK.getStatusCode());
    }
    
    public GResultDto<GenericEntity<List<KomisjaShortDto>>> loadObwodowaShortList(int userId, String login, String token) {
        
        if (!securityHandler.checkUser(userId, login, token)) {
            return GResultDto.invalidResult(UNAUTHORIZED.getStatusCode());
        }
        
        OpwUser user = userBean.findUser(userId);
        logger.trace("userId {} user {} obwodowa {} wynik {} ", user.getId(), user.getEmail(), user.getOpwObwodowaKomisjaList().size(), user.getOpwWynikList().size());
        
        List<KomisjaShortDto> resultList = new ArrayList<>();
        
        for (OpwObwodowaKomisja obwodowa : user.getOpwObwodowaKomisjaList()) {
            int countWynik = wynikBean.countWynik(obwodowa);
            KomisjaShortDto komisja = new KomisjaShortDto(obwodowa.getId(), obwodowa.getPkwId(), obwodowa.getName(), obwodowa.getAddress(), countWynik);
            logger.trace(komisja.toString());
            resultList.add(komisja);
        }
        
        GenericEntity<List<KomisjaShortDto>> result = new GenericEntity<List<KomisjaShortDto>>(resultList) {
        };
        
        return GResultDto.validResult(OK.getStatusCode(), result);
    }

    /**
     * MOCK
     *
     * @param apiClient
     * @param apiToken
     * @param newUser
     * @return
     */
    public GResultDto register(String apiClient, String apiToken, UserRegisterDto newUser) {
        if (securityHandler.checkClient(apiClient, apiToken)) {            
            return GResultDto.validResult(UNAUTHORIZED.getStatusCode());
        }
        
        logger.info("register " + newUser.toString());
        
        OpwUser user = new OpwUser();
        
        user.setFirstname(newUser.getFirstname());
        user.setLastname(newUser.getLastname());
        user.setEmail(newUser.getEmail());
        user.setPhone(newUser.getPhone());
        
        String passwordPlain = userBean.generatePassword();
        String userSalt = userBean.generatePassword(8);
        user.setSalt(userSalt);
        user.setToken(userBean.generateToken());
        user.setActive(false);
        user.setDateCreated(new Date());
        user.setType("U"); // TODO move to ENUM
        user.setOrigin(apiClient);
        
        mailBean.sendMailWelcome(user, passwordPlain, false);
        user.setPassword(userBean.saltPassword(OpwConfigStatic.APP_SALT, userSalt, passwordPlain));
        try {
            userBean.create(user);
        } catch (Exception e) {
            logger.error("err {} ", e.getMessage());
            return GResultDto.invalidResult(BAD_REQUEST.getStatusCode());
        }
        
        return GResultDto.validResult(OK.getStatusCode());
    }
    
}
