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
package com.adamkowalewski.opw.webservice.controller;

import com.adamkowalewski.opw.bean.KandydatBean;
import com.adamkowalewski.opw.bean.OkregowaBean;
import com.adamkowalewski.opw.bean.WynikBean;
import com.adamkowalewski.opw.entity.OpwKandydat;
import com.adamkowalewski.opw.entity.OpwOkregowaKomisja;
import com.adamkowalewski.opw.entity.OpwWynik;
import com.adamkowalewski.opw.webservice.dto.WynikDto;
import com.adamkowalewski.opw.webservice.security.SecurityHandler;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Provides business logic for webservice around Wynik.
 *
 * @author Adam Kowalewski
 */
@Stateless
public class WynikServiceEjb implements Serializable {

    private final static Logger logger = LoggerFactory.getLogger(WynikServiceEjb.class);
    
    @Inject
    SecurityHandler securityHandler;
    @EJB
    KandydatBean kandydatBean;

    @EJB
    OkregowaBean okregowaBean;
    @EJB
    WynikBean wynikBean;

    public WynikServiceEjb() {
    }

    /**
     * todo comment
     *
     * @param wynikId
     * @param login
     * @param token
     * @return
     * @author Adam Kowalewski
     * @version 2015.05.01
     */
    public Response loadWynikSingle(int wynikId, String login, String token) {
        
        if (!securityHandler.checkUser(login, token)) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
        
        OpwWynik wynik = wynikBean.find(wynikId);

        WynikDto result = new WynikDto(
                wynik.getVotersValid(), wynik.getVotersAmount(),
                wynik.getCardsValid(), 
                wynik.getVotesInvalid(), wynik.getVotesValid(),
                wynik.getK1(), wynik.getK2(), wynik.getK3(), wynik.getK4(),
                wynik.getK5(), wynik.getK6(), wynik.getK7(), wynik.getK8(),
                wynik.getK9(), wynik.getK10(), wynik.getK11());

        return Response.ok().entity(result).build();
    }

    public List<OpwKandydat> kandydatFindAll() {
        return kandydatBean.findAll();
    }

    public List<OpwOkregowaKomisja> obwodowaFindAll() {
        return okregowaBean.findAll();
    }

}
