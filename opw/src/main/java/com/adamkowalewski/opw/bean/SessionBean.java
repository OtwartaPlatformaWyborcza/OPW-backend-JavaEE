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

import com.adamkowalewski.opw.entity.OpwSession;
import com.adamkowalewski.opw.entity.OpwUser;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Adam Kowalewski
 */
@Stateless
public class SessionBean extends AbstractOpwFacade<OpwSession> implements Serializable {

    private static final Logger logger = LoggerFactory.getLogger(SessionBean.class);

    @PersistenceContext(unitName = PU_OPW)
    private EntityManager em;

    public SessionBean() {
        super(OpwSession.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public List<OpwSession> find(Boolean status){
        Query q = em.createNamedQuery("OpwSession.findByActive");
        q.setParameter("active", status);
        return q.getResultList();
    }

    public OpwSession find(OpwUser user, String token) {
        Query q = em.createQuery("SELECT o FROM OpwSession o WHERE o.token = :token AND o.opwUserId = :user");
        q.setParameter("token", token);
        q.setParameter("user", user);

        try {
            return (OpwSession) q.getSingleResult();
        } catch (PersistenceException e) {
            logger.error("Ex {} for user {} and session token {}", e.getMessage(), user.getEmail(), token);
            return null;
        }
    }

    public OpwSession find(String token) {
        Query q = em.createNamedQuery("OpwSession.findByToken");
        q.setParameter("token", token);

        try {
            return (OpwSession) q.getSingleResult();
        } catch (PersistenceException e) {
            logger.error("Ex {} for session token {}", e.getMessage(), token);
            return null;
        }
    }

}
