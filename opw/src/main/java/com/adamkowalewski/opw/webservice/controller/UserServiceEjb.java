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

import com.adamkowalewski.opw.bean.MailBean;
import com.adamkowalewski.opw.bean.UserBean;
import com.adamkowalewski.opw.bean.WynikBean;
import com.adamkowalewski.opw.entity.OpwObwodowaKomisja;
import com.adamkowalewski.opw.entity.OpwUser;
import com.adamkowalewski.opw.view.OpwConfigStatic;
import com.adamkowalewski.opw.webservice.dto.KomisjaShortDto;
import com.adamkowalewski.opw.webservice.dto.UserDto;
import com.adamkowalewski.opw.webservice.dto.UserRegisterDto;
import com.adamkowalewski.opw.webservice.security.SecurityHandler;
import com.adamkowalewski.opw.webservice.security.SecurityObject;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Adam Kowalewski
 */
@Stateless
public class UserServiceEjb implements Serializable {

    private final static Logger logger = LoggerFactory.getLogger(UserServiceEjb.class);

    @Inject
    SecurityHandler securityHandler;
    @EJB
    UserBean userBean;
    @EJB
    WynikBean wynikBean;
    @EJB 
    MailBean mailBean;

    public UserServiceEjb() {
    }

    public Response login(String login, String password) {

        if (securityHandler.getUserMap().containsKey(login)) {
            SecurityObject old = securityHandler.getUserMap().get(login);
            // todo time check and logger
            securityHandler.getUserMap().remove(login);
        }

        OpwUser user = userBean.verifyCredentials(login, password, OpwConfigStatic.APP_SALT);

        // if auth failed 
        if (user == null) {
            logger.error("REST Login failed for {}.", login);
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
        // auth ok 
        String restToken = userBean.encryptSHA(userBean.generatePassword());

        Date timeout = new Date();

        SecurityObject so = new SecurityObject(user.getId(), login, restToken, timeout);
        securityHandler.getUserMap().put(login, so);

        Response response = Response.ok()
                .entity(new UserDto(user.getId(), user.getFirstname(), user.getLastname(), login, restToken, true, String.valueOf(timeout.getTime())))
                .build();
        return response;

    }

    /**
     * Logout REST user.
     *
     * @param login used for authentication.
     * @param token used for authentication.
     * @return <code>200</code> when logged out, otherwise <code>401</code>.
     * @author Adam Kowalewski
     * @version 2015.04.26
     */
    public Response logout(String login, String token) {

        if (securityHandler.getUserMap().containsKey(login)) {
            SecurityObject user = securityHandler.getUserMap().get(login);

            if (user.getToken().equals(token)) {
                securityHandler.getUserMap().remove(login);
                return Response.ok().build();
            }
        }

        logger.error("REST logout failed for {} - {}", login, token);
        return Response.status(Response.Status.UNAUTHORIZED).build();
    }

    public Response loadObwodowaShortList(int userId, String login, String token) {

        if (!securityHandler.checkUser(userId, login, token)) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }

        OpwUser user = userBean.findUser(userId);
        logger.trace("userId: {} user: {} obwodowa: {} wynik: {} ", user.getId(), user.getEmail(), user.getOpwObwodowaKomisjaList().size(), user.getOpwWynikList().size());

        List<KomisjaShortDto> resultList = new ArrayList<>();

        for (OpwObwodowaKomisja obwodowa : user.getOpwObwodowaKomisjaList()) {
            int countWynik = wynikBean.countWynik(obwodowa);
            KomisjaShortDto komisja = new KomisjaShortDto(obwodowa.getId(), obwodowa.getPkwId(), obwodowa.getName(), obwodowa.getAddress(), countWynik);
            logger.trace(komisja.toString());
            resultList.add(komisja);
        }

        GenericEntity<List<KomisjaShortDto>> result = new GenericEntity<List<KomisjaShortDto>>(resultList) {
        };

        return Response.ok().entity(result).build();

    }

    /**
     * MOCK
     *
     * @param apiClient
     * @param apiToken
     * @param newUser
     * @return
     */
    public Response register(String apiClient, String apiToken, UserRegisterDto newUser) {

        if (securityHandler.checkClient(apiClient, apiToken)) {
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
            } catch (Exception e){
                logger.error("err {} ", e.getMessage() );
                return Response.status(Response.Status.BAD_REQUEST).build();
            }
            

            return Response.status(Response.Status.OK).build();
        }

        logger.error("invalid client: {} token: {}", apiClient, apiToken);
        return Response.status(Response.Status.UNAUTHORIZED).build();
    }

}
