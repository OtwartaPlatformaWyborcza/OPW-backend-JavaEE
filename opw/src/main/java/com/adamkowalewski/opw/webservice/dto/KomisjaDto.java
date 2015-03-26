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
package com.adamkowalewski.opw.webservice.dto;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Adam Kowalewski
 */
public class KomisjaDto implements Serializable {

    private String pkwId;
    private String name;
    private String address;
    private OkregowaDto okregowa;
    private List<KandydatDto> kandydatList;
    private List<WynikDto> wynikList;

    public KomisjaDto() {
    }

    public String getPkwId() {
        return pkwId;
    }

    public void setPkwId(String pkwId) {
        this.pkwId = pkwId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public OkregowaDto getOkregowa() {
        return okregowa;
    }

    public void setOkregowa(OkregowaDto okregowa) {
        this.okregowa = okregowa;
    }

    public List<KandydatDto> getKandydatList() {
        return kandydatList;
    }

    public void setKandydatList(List<KandydatDto> kandydatList) {
        this.kandydatList = kandydatList;
    }

    public List<WynikDto> getWynikList() {
        return wynikList;
    }

    public void setWynikList(List<WynikDto> wynikList) {
        this.wynikList = wynikList;
    }

}
