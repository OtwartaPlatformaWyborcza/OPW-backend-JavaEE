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

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Adam Kowalewski
 */
@Named
@ApplicationScoped
public class SecurityHandler implements Serializable {

    private final static Logger logger = LoggerFactory.getLogger(SecurityHandler.class);

    Map<String, SecurityObject> userMap;
    List<SecurityObject> userList;

    public SecurityHandler() {
        logger.info("SecurityHandler()");
        userMap = new HashMap<>();
        userList = new ArrayList<>();
    }

    public void refreshUserList() {
        userList = new ArrayList<>();
        for (Entry<String, SecurityObject> entry : userMap.entrySet()) {
            userList.add(entry.getValue());
        }
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
