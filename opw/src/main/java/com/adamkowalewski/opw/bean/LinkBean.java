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

import com.adamkowalewski.opw.entity.OpwLink;
import com.adamkowalewski.opw.entity.OpwWynik;
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
public class LinkBean extends AbstractOpwFacade<OpwLink> {

    @PersistenceContext(unitName = PU_OPW)
    private EntityManager em;

    public LinkBean() {
        super(OpwLink.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public List<OpwLink> findAll(OpwWynik wynik, boolean active){
        Query q = em.createQuery("SELECT o FROM OpwLink o WHERE o.opwWynikId = :wynik AND o.active = :active");
        q.setParameter("wynik", wynik);
        q.setParameter("active", active);
        List<OpwLink> result = q.getResultList();
        
        return result;
    }
    
}
