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
import com.adamkowalewski.opw.entity.OpwKandydat;
import com.adamkowalewski.opw.webservice.dto.KandydatDto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Adam Kowalewski
 */
@Stateless
public class KandydatEjb implements Serializable {

    @EJB
    KandydatBean kandydatBean;

    public KandydatEjb() {
    }

    public List<OpwKandydat> findAll() {
        return kandydatBean.findAll();
    }

    public List<KandydatDto> findAllDto() {
        List<OpwKandydat> kandydatList = findAll();
        List<KandydatDto> result = new ArrayList<>(kandydatList.size());

        for (OpwKandydat kandydat : kandydatList) {
            KandydatDto k = new KandydatDto(kandydat.getPkwId(), kandydat.getName());
            result.add(k);
        }
        return result;
    }
}
