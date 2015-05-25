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
package com.adamkowalewski.opw.view.controller;

import com.adamkowalewski.opw.bean.ObwodowaBean;
import com.adamkowalewski.opw.bean.UserBean;
import com.adamkowalewski.opw.bean.WynikBean;
import com.adamkowalewski.opw.entity.OpwWynik;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 * Provides reusable logic around Wynik.
 *
 * @author Adam Kowalewski
 */
@Named
@SessionScoped
public class WynikController implements Serializable {
    
    @EJB
    WynikBean wynikBean;
    @EJB
    ObwodowaBean obwodowaBean;
    @EJB
    UserBean userBean;
    
    public WynikController() {
    }    
    
    public void create(OpwWynik wynik, String obwodowaPkwId, int userId) {
        wynik.setOpwObwodowaKomisjaId(obwodowaBean.findObwodowa(obwodowaPkwId));
        wynik.setOpwUserId(userBean.find(userId));
        create(wynik);
    }
    
    public void create(List<OpwWynik> wynikList) {
        for (OpwWynik wynik : wynikList) {
            create(wynik);
        }
    }
    
    public void create(OpwWynik wynik) {
        wynik.setDateCreated(new Date());
        wynik.setActive(Boolean.TRUE);
        wynikBean.create(wynik);
    }
    
    public void edit(OpwWynik wynik) {
        wynikBean.edit(wynik);
    }
    
    public List<OpwWynik> findAll() {
        return wynikBean.findAll();
    }
    
}
