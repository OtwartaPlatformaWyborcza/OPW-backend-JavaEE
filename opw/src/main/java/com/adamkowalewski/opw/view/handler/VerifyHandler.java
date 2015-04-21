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

import com.adamkowalewski.opw.view.controller.UserController;
import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.Size;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Handler responsible for account activation.
 *
 * @author Adam Kowalewski
 */
@Named
@RequestScoped
public class VerifyHandler implements Serializable {

    private static final Logger logger = LoggerFactory.getLogger(VerifyHandler.class);

    // TODO add regex validator for mail
    @Size(max = 64)
    private String email;
    // TODO add regex validator for sha
    @Size(max = 32)
    private String code;

    private boolean actResult;

    @Inject
    UserController userController;

    /**
     * Trigger account activation.
     */
    public void verifyAccount() {
        actResult = userController.activateAccount(email, code);

        if (actResult) {
            logger.info("Account activation for email {} with token {}", email, code);
        } else {
            logger.error("Account activation failed for email {} with token {}", email, code);
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isActResult() {
        return actResult;
    }

    public void setActResult(boolean actResult) {
        this.actResult = actResult;
    }

}
