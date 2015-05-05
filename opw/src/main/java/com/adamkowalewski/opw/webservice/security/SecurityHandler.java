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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.*;
import java.util.Map.Entry;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkState;

/**
 * Handles REST security.
 *
 * @author Adam Kowalewski
 */
@Named
@ApplicationScoped
public class SecurityHandler implements Serializable {

    private final static Logger logger = LoggerFactory.getLogger(SecurityHandler.class);

    Map<String, SecurityObject> userMap;
    List<SecurityObject> userList;
    Map<String, String> clientMap;  // Todo reconsider how to auth client apps

    @EJB
    ConfigBean configBean;

    public SecurityHandler() {
        logger.info("SecurityHandler()");
        userMap = new HashMap<>();
        userList = new ArrayList<>();
        clientMap = new HashMap<>();
    }

    public void refreshUserList() {
        userList = new ArrayList<>();
        for (Entry<String, SecurityObject> entry : userMap.entrySet()) {
            userList.add(entry.getValue());
        }
    }

    /**
     * MOCK
     *
     * @param apiClient
     * @param apiToken
     * @return
     */
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
        if (userMap.containsKey(login)) {

            SecurityObject user = userMap.get(login);

            if (userId == user.getUserId()
                    && token.equals(user.getToken())
                    && !isSessionExpired(user)) {
                return true;
            }
        }
        logger.error("failed checkUser for userId: {} login: {} token: {}", userId, login, token);
        return false;
    }

    /**
     * @param login
     * @param token
     * @return
     */
    public boolean checkUser(String login, String token) {
        if (userMap.containsKey(login)) {
            SecurityObject user = userMap.get(login);
            if (token.equals(user.getToken()) && !isSessionExpired(user)) {
                return true;
            }
        }
        logger.error("failed checkUser for login: {} token: {}", login, token);
        return false;
    }

    /**
     * Checks if session is timed out.
     *
     * @param user instance representing REST user.
     * @return <code>true</code> if session timed out, otherwise
     * <code>false</code>
     * @author Adam Kowalewski
     */
    public boolean isSessionExpired(SecurityObject user) {
        checkArgument(user != null, "Expected non-null user argument");
        checkState(user.getValidTo() != null, "Expected non-null validTo");
        Date now = new Date();
        if (now.after(user.getValidTo())) {
            logger.error("Session timeout for login: {} token: {}", user.getLogin(), user.getToken());
            return true;
        }
        return false;
    }

    public void clear() {
        userMap = new HashMap<>();
    }

    public Map<String, SecurityObject> getUserMap() {
        return userMap;
    }

    public void setUserMap(Map<String, SecurityObject> userMap) {
        this.userMap = userMap;
    }

    public List<SecurityObject> getUserList() {
        return userList;
    }

    public void setUserList(List<SecurityObject> userList) {
        this.userList = userList;
    }

}
