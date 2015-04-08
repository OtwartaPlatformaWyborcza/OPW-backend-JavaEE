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
package com.adamkowalewski.opw.view.dto;

import com.google.common.base.Objects;

/**
 * DTO used for CSV import of Komisja Okregowa.
 *
 * @author Adam Kowalewski
 */
public class OkregowaCsvDto {

    private int pkwId;
    private String name;
    //FIXME brakuje wojewodztw!
    private String powiaty;
    private String miasta;
    private boolean duplicate;

    public OkregowaCsvDto() {
    }

    public OkregowaCsvDto(int pkwId, String name, String powiaty, String miasta) {
        this.pkwId = pkwId;
        this.name = name;
        this.powiaty = powiaty;
        this.miasta = miasta;
    }

    public int getPkwId() {
        return pkwId;
    }

    public void setPkwId(int pkwId) {
        this.pkwId = pkwId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPowiaty() {
        return powiaty;
    }

    public void setPowiaty(String powiaty) {
        this.powiaty = powiaty;
    }

    public String getMiasta() {
        return miasta;
    }

    public void setMiasta(String miasta) {
        this.miasta = miasta;
    }

    public boolean isDuplicate() {
        return duplicate;
    }

    public void setDuplicate(boolean duplicate) {
        this.duplicate = duplicate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OkregowaCsvDto that = (OkregowaCsvDto) o;

        return Objects.equal(duplicate, that.duplicate)
                && Objects.equal(pkwId, that.pkwId)
                && Objects.equal(miasta, that.miasta)
                && Objects.equal(name, that.name)
                && Objects.equal(powiaty, that.powiaty);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(pkwId, name, powiaty, miasta, duplicate);
    }
}
