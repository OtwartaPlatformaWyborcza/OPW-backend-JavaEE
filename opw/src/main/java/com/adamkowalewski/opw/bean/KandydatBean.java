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

import com.adamkowalewski.opw.entity.OpwKandydat;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Poovides access to Kandydat.
 *
 * @author Adam Kowalewski
 */
@Stateless
public class KandydatBean extends AbstractOpwFacade<OpwKandydat> {

    @PersistenceContext(unitName = PU_OPW)
    private EntityManager em;

    public KandydatBean() {
        super(OpwKandydat.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    /**
     * Returns fullname for a Kandydat.
     *
     * TODO reconsider usage of patterns as well as UPPERCASE
     * @param kandydat instance of entity.
     * @return String representation of fullname.
     * @author Adam Kowalewski
     * @version 2015.04.10
     */
    public String getFullname(OpwKandydat kandydat) {
        return kandydat.getLastname() + " " + kandydat.getFirstname();
    }

}
