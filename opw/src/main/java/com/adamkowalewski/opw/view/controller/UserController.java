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
package com.adamkowalewski.opw.view.controller;

import com.adamkowalewski.opw.bean.MailBean;
import com.adamkowalewski.opw.entity.OpwUser;
import com.adamkowalewski.opw.bean.UserBean;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Provides reusable logic around User.
 *
 * @author Adam Kowalewski
 */
@Named
@SessionScoped
public class UserController implements Serializable {

    @EJB
    private UserBean bean;

    @Inject
    private MailBean mailBean;
    @Inject
    private ConfigController configController;

    public UserController() {
    }

    public UserController(UserBean bean, MailBean mailController) {
        this.bean = bean;
        this.mailBean = mailController;
    }

    public boolean activateAccount(String email, String token) {
        return bean.activateAccount(email, token);
    }

    public OpwUser authenticate(String login, String password) {
        return bean.verifyCredentials(login, password, configController.getApplicationSalt());
    }

    /**
     * Creates a new user within database and generates a random password.
     *
     * @param user instance of user.
     * @author Adam Kowalewski
     * @version 2015.04.14
     */
    public void create(OpwUser user) {
        String passwordPlain = bean.generatePassword();
        String userSalt = bean.generatePassword(8);
        user.setSalt(userSalt);
        user.setToken(bean.generateToken());
        if (user.getType() == null) {
            user.setType("U"); // TODO enum
        }
        user.setActive(false);
        user.setDateCreated(new Date());
        mailBean.sendMailWelcome(user, passwordPlain, true);
        user.setPassword(bean.saltPassword(configController.getApplicationSalt(), userSalt, passwordPlain));
        bean.create(user);
    }

    /**
     * Generates and persists a new password for user as well as triggers E-Mail
     * notification.
     *
     * @param user instance of user.
     *
     * @author Adam Kowalewski
     * @version 2015.03.29
     */
    public void resetPassword(OpwUser user) {
        String passwordPlain = bean.generatePassword();
        mailBean.sendMailPasswordNew(user, passwordPlain);
        user.setPassword(bean.saltPassword(configController.getApplicationSalt(), user.getSalt(), passwordPlain));
        bean.edit(user);
    }

    public void delete(OpwUser user) {
        bean.remove(user);
    }

    public OpwUser find(int id) {
        return bean.findUser(id);
    }

    public void edit(OpwUser user) {
        bean.edit(user);
    }

    public List<OpwUser> findAll() {
        return bean.findAll();
    }
}
