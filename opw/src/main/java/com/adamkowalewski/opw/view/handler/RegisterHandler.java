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

import com.adamkowalewski.opw.bean.ConfigBean;
import com.adamkowalewski.opw.entity.OpwUser;
import com.adamkowalewski.opw.view.OpwConfigStatic;
import com.adamkowalewski.opw.view.controller.MsgController;
import com.adamkowalewski.opw.view.controller.UserController;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Adam Kowalewski
 */
@Named
@ViewScoped
public class RegisterHandler implements Serializable {

    private static final Logger logger = LoggerFactory.getLogger(RegisterHandler.class);

    private OpwUser user;

    @NotNull
    @Pattern(regexp = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message = "Invalid email")
    @Size(max = 64)
    private String email;

    @Inject
    UserController userController;
    @EJB
    ConfigBean configBean;

    public RegisterHandler() {
        logger.trace("Registration started.");
        user = new OpwUser();
    }

    public String performRegister() {

        if (!Boolean.valueOf(configBean.readConfigValue(OpwConfigStatic.CFG_KEY_REGISTER))) {
            MsgController.addErrorMessage(MsgController.getLocalizedMessage("registerDisabled"));
            return "index";
        }

        user.setType("RU");
        user.setOrigin("RegisterHandler");
        user.setEmail(email);
        userController.create(user);
        logger.trace("Registration done {}", user.getEmail());
        return "index";
    }

    public OpwUser getUser() {
        return user;
    }

    public void setUser(OpwUser user) {
        this.user = user;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
