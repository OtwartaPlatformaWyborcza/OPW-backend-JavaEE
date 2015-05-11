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
import com.adamkowalewski.opw.webservice.dto.DashboardDto;
import com.adamkowalewski.opw.webservice.dto.GResultDto;
import com.adamkowalewski.opw.webservice.dto.KandydatDto;
import com.adamkowalewski.opw.webservice.dto.WynikDto;
import com.adamkowalewski.opw.webservice.security.SecurityHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import static javax.ws.rs.core.Response.Status.*;

/**
 * Provides business logic for webservice around Wynik.
 *
 * @author Adam Kowalewski
 */
@Stateless
public class WynikServiceEjb implements Serializable {

    private final static Logger logger = LoggerFactory.getLogger(WynikServiceEjb.class);

    private final static int OBWODOWA_ALL = 27816;
    private final static int FREKWENCJA_ALL = 30229501;

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
    public GResultDto<WynikDto> loadWynikSingle(int wynikId, String login, String token) {

        if (!securityHandler.checkUser(login, token)) {
            return GResultDto.invalidResult(UNAUTHORIZED.getStatusCode());
        }

        OpwWynik wynik = wynikBean.find(wynikId);

        WynikDto result = new WynikDto(
                wynik.getVotersValid(), wynik.getVotersAmount(),
                wynik.getCardsValid(),
                wynik.getVotesInvalid(), wynik.getVotesValid(),
                wynik.getK1(), wynik.getK2(), wynik.getK3(), wynik.getK4(),
                wynik.getK5(), wynik.getK6(), wynik.getK7(), wynik.getK8(),
                wynik.getK9(), wynik.getK10(), wynik.getK11());

        result.setRatedPositiv(wynik.getRatedPositiv());
        result.setRatedNegativ(wynik.getRatedNegativ());
        result.setTimestampCreated(String.valueOf(wynik.getDateCreated().getTime()));
        return GResultDto.validResult(OK.getStatusCode(), result);
    }

    public GResultDto<Integer> ratePositive(int wynikId) {
        int c = wynikBean.ratePositive(wynikId);
        return GResultDto.validResult(OK.getStatusCode(), c);
    }

    public GResultDto<Integer> rateNegative(int wynikId) {
        int c = wynikBean.rateNegative(wynikId);
        return GResultDto.validResult(OK.getStatusCode(), c);
    }

    public GResultDto<DashboardDto> wynik() {
        try {
            int k1 = 0, k2 = 0, k3 = 0, k4 = 0, k5 = 0, k6 = 0, k7 = 0, k8 = 0, k9 = 0, k10 = 0, k11 = 0,
                    votersValid = 0;

            List<OpwWynik> currentElectionResults = wynikBean.fetchCurrentElectionResults();
            for (OpwWynik wynik : currentElectionResults) {
                k1 += wynik.getK1();
                k2 += wynik.getK2();
                k3 += wynik.getK3();
                k4 += wynik.getK4();
                k5 += wynik.getK5();
                k6 += wynik.getK6();
                k7 += wynik.getK7();
                k8 += wynik.getK8();
                k9 += wynik.getK9();
                k10 += wynik.getK10();
                k11 += wynik.getK11();                
                votersValid += wynik.getVotersValid();
            }

            List<OpwKandydat> kandydatList = kandydatBean.findAll();

            DashboardDto dashboard = new DashboardDto();
            for (OpwKandydat opwKandydat : kandydatList) {                
                dashboard.getKandydatList().add(new KandydatDto(
                                opwKandydat.getPkwId(), opwKandydat.getFirstname(), opwKandydat.getLastname(), 0)
                );
            }

            dashboard.setExportDate(new Date());
            dashboard.setObwodowa(currentElectionResults.size());
            dashboard.setObwodowaAll(OBWODOWA_ALL);
            dashboard.setFrekwencja(votersValid);
            dashboard.setFrekwencjaAll(FREKWENCJA_ALL);
            dashboard.getKandydatList().get(0).setGlosow(k1);
            dashboard.getKandydatList().get(1).setGlosow(k2);
            dashboard.getKandydatList().get(2).setGlosow(k3);
            dashboard.getKandydatList().get(3).setGlosow(k4);
            dashboard.getKandydatList().get(4).setGlosow(k5);
            dashboard.getKandydatList().get(5).setGlosow(k6);
            dashboard.getKandydatList().get(6).setGlosow(k7);
            dashboard.getKandydatList().get(7).setGlosow(k8);
            dashboard.getKandydatList().get(8).setGlosow(k9);
            dashboard.getKandydatList().get(9).setGlosow(k10);
            dashboard.getKandydatList().get(10).setGlosow(k11);
            //TODO Dodac komisje okregowe
            return GResultDto.validResult(OK.getStatusCode(), dashboard);
        } catch (Exception e) {
            logger.error("Ex ", e);
            return GResultDto.invalidResult(BAD_REQUEST.getStatusCode());
        }
    }

    public List<OpwKandydat> kandydatFindAll() {
        return kandydatBean.findAll();
    }

    public List<OpwOkregowaKomisja> obwodowaFindAll() {
        return okregowaBean.findAll();
    }
}
