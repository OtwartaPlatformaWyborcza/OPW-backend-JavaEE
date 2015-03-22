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

package com.adamkowalewski.opw.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Adam Kowalewski
 */
@Entity
@Table(name = "opw_wynik_kandydat", catalog = "opw", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OpwWynikKandydat.findAll", query = "SELECT o FROM OpwWynikKandydat o"),
    @NamedQuery(name = "OpwWynikKandydat.findById", query = "SELECT o FROM OpwWynikKandydat o WHERE o.id = :id"),
    @NamedQuery(name = "OpwWynikKandydat.findByResult", query = "SELECT o FROM OpwWynikKandydat o WHERE o.result = :result")})
public class OpwWynikKandydat implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "result", nullable = false)
    private int result;
    @JoinColumn(name = "opw_wynik_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private OpwWynik opwWynikId;
    @JoinColumn(name = "opw_kandydat_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private OpwKandydat opwKandydatId;

    public OpwWynikKandydat() {
    }

    public OpwWynikKandydat(Integer id) {
        this.id = id;
    }

    public OpwWynikKandydat(Integer id, int result) {
        this.id = id;
        this.result = result;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public OpwWynik getOpwWynikId() {
        return opwWynikId;
    }

    public void setOpwWynikId(OpwWynik opwWynikId) {
        this.opwWynikId = opwWynikId;
    }

    public OpwKandydat getOpwKandydatId() {
        return opwKandydatId;
    }

    public void setOpwKandydatId(OpwKandydat opwKandydatId) {
        this.opwKandydatId = opwKandydatId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OpwWynikKandydat)) {
            return false;
        }
        OpwWynikKandydat other = (OpwWynikKandydat) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.adamkowalewski.opw.entity.OpwWynikKandydat[ id=" + id + " ]";
    }
    
}
