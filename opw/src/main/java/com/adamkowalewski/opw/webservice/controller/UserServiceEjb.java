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

import com.adamkowalewski.opw.bean.UserBean;
import com.adamkowalewski.opw.entity.OpwUser;
import com.adamkowalewski.opw.view.OpwConfig;
import com.adamkowalewski.opw.webservice.dto.UserDto;
import com.adamkowalewski.opw.webservice.security.SecurityHandler;
import com.adamkowalewski.opw.webservice.security.SecurityObject;
import java.io.Serializable;
import java.util.Date;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
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

    public UserServiceEjb() {
    }

    public Response login(String login, String password) {

        if (securityHandler.getUserMap().containsKey(login)) {
            SecurityObject old = securityHandler.getUserMap().get(login);
            // todo time check and logger
            securityHandler.getUserMap().remove(login);
        }

        OpwUser user = userBean.verifyCredentials(login, password, OpwConfig.APP_SALT);

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
}
