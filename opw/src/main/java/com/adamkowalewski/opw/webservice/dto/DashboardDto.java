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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * DTO for all dashboard clients.
 *
 * @author Adam Kowalewski
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class DashboardDto {

    private int obwodowa;       //liczba komisji z ktorych mamy protokoły
    private int obwodowaAll;    //wsztstkie dostepne komisje
    private int frekwencja;     //wszystkich nadeslanych votersAmount
    private int frekwencjaAll;  //wsztstkich allowedToVote
    private String exportDate;

    private List<KandydatDto> kandydatList;
    private List<WynikOkregowaDto> okregowaList;

    public DashboardDto() {
        this.kandydatList = new ArrayList<>();
        this.okregowaList = new ArrayList<>();
    }

    public DashboardDto(String exportDateTimestamp, int obwodowaAll, int obwodowa, int frekwencjaAll, int frekwencja) {
        this.exportDate = exportDateTimestamp;
        this.obwodowaAll = obwodowaAll;
        this.obwodowa = obwodowa;
        this.frekwencja = frekwencja;
        this.frekwencjaAll = frekwencjaAll;
        this.kandydatList = new ArrayList<>();
        this.okregowaList = new ArrayList<>();
    }

    public int getObwodowaAll() {
        return obwodowaAll;
    }

    public void setObwodowaAll(int obwodowaAll) {
        this.obwodowaAll = obwodowaAll;
    }

    public int getObwodowa() {
        return obwodowa;
    }

    public void setObwodowa(int obwodowa) {
        this.obwodowa = obwodowa;
    }

    public List<KandydatDto> getKandydatList() {
        return kandydatList;
    }

    public void setKandydatList(List<KandydatDto> kandydatList) {
        this.kandydatList = kandydatList;
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

    public String getExportDate() {
        return exportDate;
    }

    public void setExportDate(String exportDate) {
        this.exportDate = exportDate;
    }

    public List<WynikOkregowaDto> getOkregowaList() {
        return okregowaList;
    }

    public void setOkregowaList(List<WynikOkregowaDto> okregowaList) {
        this.okregowaList = okregowaList;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("obwodowa", obwodowa)
                .add("obwodowaAll", obwodowaAll)
                .add("frekwencja", frekwencja)
                .add("frekwencjaAll", frekwencjaAll)
                .add("exportDate", exportDate)
                .add("kandydatList", kandydatList)
                .add("okregowaList", okregowaList)
                .toString();
    }
}
