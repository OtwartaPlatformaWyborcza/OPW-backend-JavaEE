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

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Adam Kowalewski
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class WynikDto {

    private int uprawnionych;
    private int glosujacych;
    private int kartWarznych;
    private int kartNieWarznych;
    private int glosowWarznych;

    private List<KandydatDto> kandydatList;

    public WynikDto() {
    }

    public int getUprawnionych() {
        return uprawnionych;
    }

    public void setUprawnionych(int uprawnionych) {
        this.uprawnionych = uprawnionych;
    }

    public int getGlosujacych() {
        return glosujacych;
    }

    public void setGlosujacych(int glosujacych) {
        this.glosujacych = glosujacych;
    }

    public int getKartWarznych() {
        return kartWarznych;
    }

    public void setKartWarznych(int kartWarznych) {
        this.kartWarznych = kartWarznych;
    }

    public int getKartNieWarznych() {
        return kartNieWarznych;
    }

    public void setKartNieWarznych(int kartNieWarznych) {
        this.kartNieWarznych = kartNieWarznych;
    }

    public int getGlosowWarznych() {
        return glosowWarznych;
    }

    public void setGlosowWarznych(int glosowWarznych) {
        this.glosowWarznych = glosowWarznych;
    }

    public List<KandydatDto> getKandydatList() {
        return kandydatList;
    }

    public void setKandydatList(List<KandydatDto> kandydatList) {
        this.kandydatList = kandydatList;
    }

}
