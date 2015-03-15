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
package com.adamkowalewski.opw.session.bean;

import com.adamkowalewski.opw.entity.OpwUser;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Adam Kowalewski
 */
@Stateless
public class UserBean extends AbstractOpwFacade<OpwUser> {

    @PersistenceContext(unitName = PU_OPW)
    private EntityManager em;

    public UserBean() {
        super(OpwUser.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    /**
     * Returns single user instance by given login / E-Mail address.
     *
     * @param login E-Mail address to look for.
     * @return full instance of OpwUser or null if no record was found.
     * @author Adam Kowalewski
     * @version 2015.03.15
     * @TODO add exception handling 
     */
    public OpwUser findUser(String login) {
        Query q = em.createNamedQuery("OpwUser.findByEmail");
        q.setParameter("login", login);
        List<OpwUser> resultList = q.getResultList();
        if (resultList.isEmpty()) {
            //@ToDo throw an exception
            return null;
        } else {
            return resultList.get(0);
        }
    }

    /**
     * Returns single user by user id.
     *
     * @param id user id.
     * @return full instance of OpwUser.
     * @author Adam Kowalewski
     * @version 2015.03.15
     * @TODO add exception handling 
     */
    public OpwUser findUser(int id) {
        Query q = em.createNamedQuery("OpwUser.findById");
        q.setParameter("id", id);
        return (OpwUser) q.getSingleResult();
    }

}
