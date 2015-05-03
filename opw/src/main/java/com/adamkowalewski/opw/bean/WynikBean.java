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
import com.adamkowalewski.opw.entity.OpwUser;
import com.adamkowalewski.opw.entity.OpwWynik;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Provides access to wynik.
 *
 * @author Adam Kowalewski
 */
@Stateless
public class WynikBean extends AbstractOpwFacade<OpwWynik> implements Serializable {

    private static final Logger logger = LoggerFactory.getLogger(WynikBean.class);

    @PersistenceContext(unitName = PU_OPW)
    private EntityManager em;

    public WynikBean() {
        super(OpwWynik.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    /**
     * Increments positive rating by 1.
     *
     * @param wynikId ID of Wynik to increment.
     * @return current counter.
     * @author Adam Kowalewski
     * @version 2015.05.02
     */
    public int ratePositive(int wynikId) {
        OpwWynik wynik = find(wynikId);
        int counter = wynik.getRatedPositiv();
        counter++;
        wynik.setRatedPositiv(counter);
        edit(wynik);
        logger.trace("rated pos wynik {} counter {}", wynikId, counter);
        return counter;
    }

    /**
     * Increments negative rating by 1.
     *
     * @param wynikId ID of Wynik to increment.
     * @return current counter.
     * @author Adam Kowalewski
     * @version 2015.05.02
     */
    public int rateNegative(int wynikId) {
        OpwWynik wynik = find(wynikId);
        int counter = wynik.getRatedNegativ();
        counter++;
        wynik.setRatedNegativ(counter);
        edit(wynik);
        logger.trace("rated neg wynik {} counter {}", wynikId, counter);
        return counter;
    }

    public List<OpwWynik> find(OpwObwodowaKomisja obwodowa) {
        Query q = em.createQuery("SELECT o FROM OpwWynik o WHERE o.opwObwodowaKomisjaId = :obwodowa");
        q.setParameter("obwodowa", obwodowa);
        List<OpwWynik> result = q.getResultList();
        logger.trace("For Obwodowa {} returned {} Wynik records.", obwodowa.getPkwId(), result.size());
        return result;
    }

    /**
     * Returns the number of Wynik uploaded for given Komisja Obwodowa.
     *
     * @param obwodowa Komisja Obwodowa to use.
     * @return number of Wynik in database matching given criteria.
     * @author Adam Kowalewski
     * @version 2015.05.01
     */
    public int countWynik(OpwObwodowaKomisja obwodowa) {
        Query q = em.createQuery("SELECT o FROM OpwWynik o WHERE o.opwObwodowaKomisjaId = :obwodowa");
        q.setParameter("obwodowa", obwodowa);
        int result = q.getResultList().size();
        logger.trace("For Obwodowa {} counted {} Wynik records.", obwodowa.getPkwId(), result);
        return result;
    }

    /**
     * Returns the number of Wynik uploaded by user for Komisja Obwodowa.
     *
     * @param obwodowa Komisja Obwodowa to use.
     * @param user uploader.
     * @return number of Wynik in database matching given criteria.
     * @author Adam Kowalewski
     * @version 2015.05.01
     */
    public int countWynik(OpwObwodowaKomisja obwodowa, OpwUser user) {
        Query q = em.createQuery("SELECT o FROM OpwWynik o WHERE o.opwObwodowaKomisjaId = :obwodowa AND o.opwUserId = :user");
        q.setParameter("obwodowa", obwodowa);
        q.setParameter("user", user);
        int result = q.getResultList().size();
        logger.trace("For Obwodowa {} and user {} counted {} Wynik records.", obwodowa.getPkwId(), user.getEmail(), result);
        return result;
    }

}
