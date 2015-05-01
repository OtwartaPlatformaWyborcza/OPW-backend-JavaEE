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
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Adam Kowalewski
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class WynikShortDto implements Serializable {

    private int id;
    private String uploadTimestamp;
    private int ratedPositiv, ratedNegativ;

    public WynikShortDto() {
    }

    public WynikShortDto(int id, String uploadTimestamp, int ratedPositiv, int ratedNegativ) {
        this.id = id;
        this.uploadTimestamp = uploadTimestamp;
        this.ratedPositiv = ratedPositiv;
        this.ratedNegativ = ratedNegativ;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUploadTimestamp() {
        return uploadTimestamp;
    }

    public void setUploadTimestamp(String uploadTimestamp) {
        this.uploadTimestamp = uploadTimestamp;
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

    @Override
    public String toString() {
        return "WynikShortDto{"
                + "id=" + id
                + ", uploadTimestamp=" + uploadTimestamp
                + ", ratedPositiv=" + ratedPositiv
                + ", ratedNegativ=" + ratedNegativ
                + '}';
    }

}
