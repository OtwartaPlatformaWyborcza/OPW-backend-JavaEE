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
package com.adamkowalewski.opw.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Represents Access Control List (ACL) for JSF views. It's a whitelist
 * approach.
 *
 * @author Adam Kowalewski
 */
@Named
@SessionScoped
public class AccessControlList implements Serializable {
    
    private static final Logger logger = LoggerFactory.getLogger(AccessControlList.class);

    @Inject
    private Identity identity;

    private final List<String> accessAll;
    private final List<String> accessLogin;

    public AccessControlList() {
        accessAll = new ArrayList<>();
        accessLogin = new ArrayList<>();
        populateAll();
        populateLogin();
    }

    public boolean accessView(String name) {                
        if (accessAll.contains(name)) {
            return true;
        }
        
        if (accessLogin.contains(name) && identity.isLoggedin()){
            return true; 
        }
        
        logger.error("Rejected access to {} page", name);
        return false;
    }

    private void populateLogin() {
        accessLogin.add("/dashboard.xhtml");

        accessLogin.add("/importObwodowa.xhtml");
        accessLogin.add("/importOkregowa.xhtml");
        accessLogin.add("/importUser.xhtml");

        accessLogin.add("/kandydat.xhtml");
        accessLogin.add("/kandydatCreate.xhtml");
        accessLogin.add("/kandydatEdit.xhtml");

        accessLogin.add("/obwodowaEdit.xhtml");
        accessLogin.add("/obwodowaCreate.xhtml");
        accessLogin.add("/obwodowa.xhtml");

        accessLogin.add("/okregowa.xhtml");
        accessLogin.add("/okregowaCreate.xhtml");
        accessLogin.add("/okregowaEdit.xhtml");
        accessLogin.add("/user.xhtml");
        accessLogin.add("/userCreate.xhtml");
        accessLogin.add("/userEdit.xhtml");

        accessLogin.add("/profileEdit.xhtml");
    }

    private void populateAll() {
        accessAll.add("/index.xhtml");
        accessAll.add("/login.xhtml");
        accessAll.add("/logout.xhtml");
        accessAll.add("/verify.xhtml");
        accessAll.add("/register.xhtml");
        accessAll.add("/errorSites/error404.xhtml");
        accessAll.add("/errorSites/error500.xhtml");
    }
}
