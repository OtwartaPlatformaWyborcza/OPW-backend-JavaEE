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

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

/**
 * DTO used for CSV import of Komisja Obwodowa.
 *
 * @author Adam Kowalewski
 * @version 2015.04.20
 */
public class ObwodowaCsvDto {

    private int wojewodztwoId;  // refactoring needed since we use here wojewodztwoId
    private String pkwId;
    private int obwodNr;
    private String name;
    private String address;
    private String type;
    private int allowedToVote;
    private boolean duplicate;

    public ObwodowaCsvDto() {
    }

    public ObwodowaCsvDto(int wojewodztwoId, String pkwId, int obwodNr, String name, String address, String type, int allowedToVote) {
        this.wojewodztwoId = wojewodztwoId;
        this.pkwId = pkwId;
        this.obwodNr = obwodNr;
        this.name = name;
        this.address = address;
        this.type = type;
        this.allowedToVote = allowedToVote;
    }

    public ObwodowaCsvDto(int wojewodztwoId, String pkwId, int obwodNr, String name, String address, String type, int allowedToVote, boolean duplicate) {
        this.wojewodztwoId = wojewodztwoId;
        this.pkwId = pkwId;
        this.obwodNr = obwodNr;
        this.name = name;
        this.address = address;
        this.type = type;
        this.allowedToVote = allowedToVote;
        this.duplicate = duplicate;
    }

    public int getWojewodztwoId() {
        return wojewodztwoId;
    }

    public void setWojewodztwoId(int okregowaPkwId) {
        this.wojewodztwoId = okregowaPkwId;
    }

    public String getPkwId() {
        return pkwId;
    }

    public void setPkwId(String pkwId) {
        this.pkwId = pkwId;
    }

    public int getObwodNr() {
        return obwodNr;
    }

    public void setObwodNr(int obwodNr) {
        this.obwodNr = obwodNr;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAllowedToVote() {
        return allowedToVote;
    }

    public void setAllowedToVote(int allowedToVote) {
        this.allowedToVote = allowedToVote;
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

        ObwodowaCsvDto that = (ObwodowaCsvDto) o;

        return Objects.equal(wojewodztwoId, that.wojewodztwoId)
                && Objects.equal(pkwId, that.pkwId)
                && Objects.equal(obwodNr, that.obwodNr)
                && Objects.equal(name, that.name)
                && Objects.equal(address, that.address)
                && Objects.equal(type, that.type)
                && Objects.equal(allowedToVote, that.allowedToVote);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(wojewodztwoId,
                pkwId,
                obwodNr,
                name,
                address,
                type,
                allowedToVote,
                duplicate
        );
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("wojewodztwoId", wojewodztwoId)
                .add("pkwId", pkwId)
                .add("obwodNr", obwodNr)
                .add("name", name)
                .add("address", address)
                .add("type", type)
                .add("allowedToVote", allowedToVote)
                .add("duplicate", duplicate)
                .toString();
    }
}
