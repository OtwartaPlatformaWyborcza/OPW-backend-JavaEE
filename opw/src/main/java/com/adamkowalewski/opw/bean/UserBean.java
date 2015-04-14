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
package com.adamkowalewski.opw.bean;

import com.adamkowalewski.opw.entity.OpwUser;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Provides access to user.
 *
 * @author Adam Kowalewski
 */
@Stateless
public class UserBean extends AbstractOpwFacade<OpwUser> {

    @PersistenceContext(unitName = PU_OPW)
    private EntityManager em;

    // ToDo extract to properties 
    private final int DEFAULT_PWD_LENGTH = 10;

    public UserBean() {
        super(OpwUser.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    /**
     * Verify if given E-Mail address is already a known login within OPW.
     *
     * @param email E-Mail address used by the user as login.
     * @return <code>true</code> if an account exists, otherwise
     * <code>false</code>.
     * @author Adam Kowalewski
     * @version 2015.04.09
     */
    public boolean isDuplicate(String email) {
        boolean result = true;
        try {
            findUser(email);
        } catch (NoResultException ex) {
            result = false;
        } catch (NonUniqueResultException ex) {
            result = true;
        }
        return result;
    }

    /**
     * Returns single user instance by given login / E-Mail address.
     *
     * @param login E-Mail address to look for.
     * @return full instance of OpwUser or null if no record was found.
     * @author Adam Kowalewski
     * @version 2015.03.15
     */
    public OpwUser findUser(String login) {
        Query q = em.createNamedQuery("OpwUser.findByEmail");
        q.setParameter("login", login);
        return (OpwUser) q.getSingleResult();
    }

    /**
     * Returns single user by user id.
     *
     * @param id user id.
     * @return full instance of OpwUser.
     * @author Adam Kowalewski
     * @version 2015.03.15
     */
    public OpwUser findUser(int id) {
        Query q = em.createNamedQuery("OpwUser.findById");
        q.setParameter("id", id);
        return (OpwUser) q.getSingleResult();
    }

    /**
     * Returns salted password.
     *
     * @param appSalt application level salt.
     * @param userSalt user level salt.
     * @param password password in plaintext.
     * @return salted password.
     * @author Adam Kowalewski
     * @version 2015.03.27
     */
    public String saltPassword(String appSalt, String userSalt, String password) {
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

}
