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
package com.adamkowalewski.opw.webservice.security;

import com.adamkowalewski.opw.bean.ConfigBean;
import com.adamkowalewski.opw.bean.SessionBean;
import com.adamkowalewski.opw.bean.UserBean;
import com.adamkowalewski.opw.entity.OpwSession;
import com.adamkowalewski.opw.entity.OpwUser;
import com.adamkowalewski.opw.view.controller.MsgController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.inject.Named;
import java.io.Serializable;
import java.util.*;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkState;
import javax.ejb.Stateless;

/**
 * Handles REST security.
 *
 * @author Adam Kowalewski
 */
@Named
@Stateless
public class SecurityHandler implements Serializable {

    private final static Logger logger = LoggerFactory.getLogger(SecurityHandler.class);

    @EJB
    ConfigBean configBean;
    @EJB
    UserBean userBean;
    @EJB
    SessionBean sessionBean;

    public SecurityHandler() {
    }

    public boolean checkClient(String apiClient, String apiToken) {
        // TODO extract properly
        String client = configBean.readConfigValue("CLIENT_REG_ID");
        String clientToken = configBean.readConfigValue("CLIENT_REG_TOKEN");

        if (apiClient.equals(client) && apiToken.equals(clientToken)) {
            logger.trace("");
            return true;
        }
        logger.error("failer for apiClient {} apiToken {}", apiClient, apiToken);
        return false;

    }

    public boolean checkUser(int userId, String login, String token) {
        OpwUser user = userBean.find(userId);

        if (user == null) {
            return false;
        }

        if (!user.getEmail().equals(login)) {
            return false;
        }
        OpwSession session = sessionBean.find(user, token);
        return validSession(session);
    }

    public boolean checkUser(String login, String token) {
        // TODO reconsider 
        OpwUser user = userBean.findUser(login);

        if (user == null) {
            logger.error("unknown login {}", login);
            return false;
        }
        OpwSession session = sessionBean.find(user, token);
        return validSession(session);
    }

    public boolean validSession(OpwSession session) {
        // unknown
        if (session == null) {
            return false;
        }
        // inactive
        if (!session.getActive()) {
            return false;
        }
        // expired
        if (isSessionExpired(session)) {
            logger.trace("session expired user {} token {}", session.getOpwUserId().getEmail(), session.getToken());
            session.setActive(Boolean.FALSE);
            sessionBean.edit(session);
            return false;
        }

        return true;
    }

    /**
     * Checks if session is timed out.
     *
     * @param session instance representing REST user.
     * @return <code>true</code> if session timed out, otherwise
     * <code>false</code>
     * @author Adam Kowalewski
     * @version 2015.05.08
     */
    public boolean isSessionExpired(OpwSession session) {
        checkArgument(session != null, "Expected non-null user argument");
        checkState(session.getDateValidTo() != null, "Expected non-null validTo");
        Date now = new Date();
        if (now.after(session.getDateValidTo())) {
            logger.trace("Session timeout for login: {} token: {}", session.getOpwUserId().getEmail(), session.getToken());
            return true;
        }
        return false;
    }

    public void cleanActiveSessionList() {
        
        
    }

    public List<OpwSession> loadActiveSessionList() {        
        List<OpwSession> activeList = new ArrayList<>();        
        for (OpwSession session : sessionBean.find(Boolean.TRUE)) {
            if (isSessionExpired(session)) {                
                session.setActive(Boolean.FALSE);
                sessionBean.edit(session);
                continue;
            }           
            activeList.add(session);
        }                
        return activeList;
    }

}
