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
package com.adamkowalewski.opw.view.controller.csv;

/**
 *
 * @author Adam Kowalewski
 */
public class WynikCsvDto {

    private short uprawnionych, glosujacych, kartWaznych, glosowNieWaznych, glosowWaznych;
    private String pkwId;
    private Short k1, k2;

    private String timestampCreated;
    private int ratedPositiv, ratedNegativ;

    public WynikCsvDto() {

    }

    public WynikCsvDto(short uprawnionych, short glosujacych, short kartWaznych, short glosowNieWaznych, short glosowWaznych, Short k1, Short k2, Short k3, Short k4, Short k5, Short k6, Short k7, Short k8, Short k9, Short k10, Short k11) {
        this.uprawnionych = uprawnionych;
        this.glosujacych = glosujacych;
        this.kartWaznych = kartWaznych;
        this.glosowNieWaznych = glosowNieWaznych;
        this.glosowWaznych = glosowWaznych;
        this.k1 = k1;
        this.k2 = k2;
    }

    public String getPkwId() {
        return pkwId;
    }

    public void setPkwId(String pkwId) {
        this.pkwId = pkwId;
    }

    public short getUprawnionych() {
        return uprawnionych;
    }

    public void setUprawnionych(short uprawnionych) {
        this.uprawnionych = uprawnionych;
    }

    public short getGlosujacych() {
        return glosujacych;
    }

    public void setGlosujacych(short glosujacych) {
        this.glosujacych = glosujacych;
    }

    public short getKartWaznych() {
        return kartWaznych;
    }

    public void setKartWaznych(short kartWaznych) {
        this.kartWaznych = kartWaznych;
    }

    public short getGlosowNieWaznych() {
        return glosowNieWaznych;
    }

    public void setGlosowNieWaznych(short glosowNieWaznych) {
        this.glosowNieWaznych = glosowNieWaznych;
    }

    public short getGlosowWaznych() {
        return glosowWaznych;
    }

    public void setGlosowWaznych(short glosowWaznych) {
        this.glosowWaznych = glosowWaznych;
    }

    public Short getK1() {
        return k1;
    }

    public void setK1(Short k1) {
        this.k1 = k1;
    }

    public Short getK2() {
        return k2;
    }

    public void setK2(Short k2) {
        this.k2 = k2;
    }

    public String getTimestampCreated() {
        return timestampCreated;
    }

    public void setTimestampCreated(String timestampCreated) {
        this.timestampCreated = timestampCreated;
    }

    public int getRatedPositiv() {
        return ratedPositiv;
    }

    public void setRatedPositiv(int ratedPositiv) {
        this.ratedPositiv = ratedPositiv;
    }

    public int getRatedNegativ() {
        return ratedNegativ;
    }

    public void setRatedNegativ(int ratedNegativ) {
        this.ratedNegativ = ratedNegativ;
    }

}
