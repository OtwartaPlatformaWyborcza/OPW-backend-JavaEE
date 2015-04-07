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

import com.adamkowalewski.opw.entity.OpwObwodowaKomisja;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Provides access to Komisja Obwodowa.
 *
 * @author Adam Kowalewski
 */
@Stateless
public class ObwodowaBean extends AbstractOpwFacade<OpwObwodowaKomisja> {

    @PersistenceContext(unitName = PU_OPW)
    private EntityManager em;

    public ObwodowaBean() {
        super(OpwObwodowaKomisja.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OpwObwodowaKomisja findObwodowa(String pkwId) {
        Query q = em.createNamedQuery("OpwObwodowaKomisja.findByPkwId");
        q.setParameter("pkwId", pkwId);
        return (OpwObwodowaKomisja) q.getSingleResult();
    }

    public List<OpwObwodowaKomisja> findObwodowaLike(String pkwId) {
        Query q = em.createQuery("SELECT o FROM OpwObwodowaKomisja o WHERE o.pkwId like :pkwId");
        q.setParameter("pkwId", "%" + pkwId + "%");
        return q.getResultList();
    }

}
