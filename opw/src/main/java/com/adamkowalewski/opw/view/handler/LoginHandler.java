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
package com.adamkowalewski.opw.view.handler;

import com.adamkowalewski.opw.entity.OpwUser;
import com.adamkowalewski.opw.view.Identity;
import com.adamkowalewski.opw.view.controller.MsgController;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

/**
 * Handler for login and logout operations.
 *
 * @author Adam Kowalewski
 */
@Named
@RequestScoped
public class LoginHandler implements Serializable {

    private String login;
    private String password;
    private OpwUser user;

    @Inject
    Identity identity;

    public LoginHandler() {
    }

    public String authenticate() {
        
        if (login.equals("admin") && password.equals("admin")) {
            identity.setLoggedin(true);
            identity.setFullname("Administrator");
            MsgController.addSuccessMessage(MsgController.getLocalizedMessage("loginOk"));
        }else{
            MsgController.addErrorMessage(MsgController.getLocalizedMessage("loginFailed"));
    }

        return "index";
    }

    public String logout() {
        if (identity.isLoggedin()) {
            HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
            identity.setLoggedin(false);
            session.invalidate();
        }
        MsgController.addSuccessMessage(MsgController.getLocalizedMessage("logoutInfo"));
        return "index";
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
