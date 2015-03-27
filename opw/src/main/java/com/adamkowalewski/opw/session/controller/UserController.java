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
import com.adamkowalewski.opw.session.bean.UserBean;
import java.io.Serializable;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
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

    public UserController() {
    }

    /**
     * Creates a new user within database and generates a random password.
     *
     * @param user
     */
    public void create(OpwUser user) {
        user.setPassword(generatePassword());
        bean.create(user);
    }
    // TODO
    public void sendWelcomeMail(){
        
    }

    /**
     * Generates a random password with length 10.
     *
     * @return String random password.
     * @author Adam Kowalewski
     * @version 2015.03.27
     */
    public String generatePassword() {
        SecureRandom random = new SecureRandom();
        String result = new BigInteger(130, random).toString(32);;
        result = result.substring(0, Math.min(result.length(), DEFAULT_PWD_LENGTH));
        return result;
    }

    /**
     * Generates a SHA-256 hash from the given String.
     *
     * @param value plain text password to be encrypted.
     * @return String hashed text.
     * @author KOWALEWSKI Adam
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
