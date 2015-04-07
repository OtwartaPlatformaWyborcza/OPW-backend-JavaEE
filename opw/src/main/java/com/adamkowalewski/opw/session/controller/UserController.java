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
package com.adamkowalewski.opw.session.controller;

import com.adamkowalewski.opw.entity.OpwUser;
import com.adamkowalewski.opw.bean.UserBean;
import java.io.Serializable;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
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

    // ToDo extract to properties 
    private final int DEFAULT_PWD_LENGTH = 10;

    @EJB
    private UserBean bean;

    @Inject
    private MailController mailController;

    public UserController() {
    }

    public UserController(UserBean bean, MailController mailController) {
        this.bean = bean;
        this.mailController = mailController;
    }

    /**
     * Creates a new user within database and generates a random password.
     *
     * @param user instance of user.
     * @author Adam Kowalewski
     * @version 2015.03.29
     */
    public void create(OpwUser user) {
        String passwordPlain = generatePassword();
        mailController.sendMailWelcome(user, passwordPlain);
        user.setPassword(encryptSHA(passwordPlain));
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
        String passwordPlain = generatePassword();
        mailController.sendMailPasswordNew(user, passwordPlain);
        user.setPassword(encryptSHA(passwordPlain));
        bean.edit(user);
    }

    /**
     * Generates salted password.
     *
     * @param appSalt application level salt.
     * @param userSalt user level salt.
     * @param password password in plaintext.
     * @return salted password.
     * @author Adam Kowalewski
     * @version 2015.03.27
     */
    public String generatePasswordSalted(String appSalt, String userSalt, String password) {
        return encryptSHA(appSalt + password + userSalt);
    }

    /**
     * Generates a random password with default length.
     *
     * @return String random password.
     * @author Adam Kowalewski
     * @version 2015.03.27
     */
    public String generatePassword() {
        return getPassword(DEFAULT_PWD_LENGTH);
    }

    /**
     * Generates a random password.
     *
     * @param length length for password.
     * @return String random password.
     * @author Adam Kowalewski
     * @version 2015.03.27
     */
    public String generatePassword(int length) {
        return getPassword(length);
    }

    private String getPassword(int length) {
        SecureRandom random = new SecureRandom();
        String result = new BigInteger(130, random).toString(32);;
        result = result.substring(0, Math.min(result.length(), length));
        return result;
    }

    /**
     * Generates a SHA-256 hash from the given String.
     *
     * @param value plain text password to be encrypted.
     * @return String hashed text.
     * @author Adam Kowalewski
     * @version 2015.03.27
     */
    public String encryptSHA(String value) {
        StringBuilder encrypted = new StringBuilder();
        String algorithm = "SHA-256";
        byte[] passwordArray = value.getBytes();

        try {
            MessageDigest md = MessageDigest.getInstance(algorithm);
            md.reset();
            md.update(passwordArray);
            byte[] encryptedArray = md.digest();

            for (int i = 0; i < encryptedArray.length; i++) {
                encrypted.append(Integer.toHexString(0xFF & encryptedArray[i]));
            }
        } catch (NoSuchAlgorithmException ex) {
            return null;
        }
        return encrypted.toString();
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
