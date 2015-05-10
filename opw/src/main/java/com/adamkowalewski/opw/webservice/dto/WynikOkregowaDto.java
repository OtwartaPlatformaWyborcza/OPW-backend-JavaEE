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

import com.google.common.base.MoreObjects;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * DTO represents all relevant numbers related to one Komisja Okregowa.
 *
 * @author Adam Kowalewski
 * @version 2015.04.07
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class WynikOkregowaDto implements Serializable {

    private String okregowaName;
    private int frekwencja;
    private int frekwencjaAll;
    private int obwodowa;
    private int obwodowaAll;

    public WynikOkregowaDto() {
    }

    public WynikOkregowaDto(String okregowaName) {
        this.okregowaName = okregowaName;
    }

    public WynikOkregowaDto(String okregowaName, int frekwencja, int frekwencjaAll, int obwodowa, int obwodowaAll) {
        this.okregowaName = okregowaName;
        this.frekwencja = frekwencja;
        this.frekwencjaAll = frekwencjaAll;
        this.obwodowa = obwodowa;
        this.obwodowaAll = obwodowaAll;
    }

    public String getOkregowaName() {
        return okregowaName;
    }

    public void setOkregowaName(String okregowaName) {
        this.okregowaName = okregowaName;
    }

    public int getFrekwencja() {
        return frekwencja;
    }

    public void setFrekwencja(int frekwencja) {
        this.frekwencja = frekwencja;
    }

    public int getFrekwencjaAll() {
        return frekwencjaAll;
    }

    public void setFrekwencjaAll(int frekwencjaAll) {
        this.frekwencjaAll = frekwencjaAll;
    }

    public int getObwodowa() {
        return obwodowa;
    }

    public void setObwodowa(int obwodowa) {
        this.obwodowa = obwodowa;
    }

    public int getObwodowaAll() {
        return obwodowaAll;
    }

    public void setObwodowaAll(int obwodowaAll) {
        this.obwodowaAll = obwodowaAll;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("okregowaName", okregowaName)
                .add("frekwencja", frekwencja)
                .add("frekwencjaAll", frekwencjaAll)
                .add("obwodowa", obwodowa)
                .add("obwodowaAll", obwodowaAll)
                .toString();
    }
}
