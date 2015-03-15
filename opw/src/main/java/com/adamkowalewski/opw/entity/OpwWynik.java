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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Adam Kowalewski
 */
@Entity
@Table(name = "opw_wynik", catalog = "opw", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OpwWynik.findAll", query = "SELECT o FROM OpwWynik o"),
    @NamedQuery(name = "OpwWynik.findById", query = "SELECT o FROM OpwWynik o WHERE o.id = :id"),
    @NamedQuery(name = "OpwWynik.findByVotersValid", query = "SELECT o FROM OpwWynik o WHERE o.votersValid = :votersValid"),
    @NamedQuery(name = "OpwWynik.findByVotersAmount", query = "SELECT o FROM OpwWynik o WHERE o.votersAmount = :votersAmount"),
    @NamedQuery(name = "OpwWynik.findByCardsValid", query = "SELECT o FROM OpwWynik o WHERE o.cardsValid = :cardsValid"),
    @NamedQuery(name = "OpwWynik.findByVotesInvalid", query = "SELECT o FROM OpwWynik o WHERE o.votesInvalid = :votesInvalid"),
    @NamedQuery(name = "OpwWynik.findByVotesValid", query = "SELECT o FROM OpwWynik o WHERE o.votesValid = :votesValid"),
    @NamedQuery(name = "OpwWynik.findByFileOriginal", query = "SELECT o FROM OpwWynik o WHERE o.fileOriginal = :fileOriginal")})
public class OpwWynik implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "votersValid")
    private Integer votersValid;
    @Column(name = "votersAmount")
    private Integer votersAmount;
    @Column(name = "cardsValid")
    private Integer cardsValid;
    @Column(name = "votesInvalid")
    private Integer votesInvalid;
    @Column(name = "votesValid")
    private Integer votesValid;
    @Size(max = 128)
    @Column(name = "fileOriginal", length = 128)
    private String fileOriginal;
    @JoinColumn(name = "opw_obwodowa_komisja_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private OpwObwodowaKomisja opwObwodowaKomisjaId;

    public OpwWynik() {
    }

    public OpwWynik(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVotersValid() {
        return votersValid;
    }

    public void setVotersValid(Integer votersValid) {
        this.votersValid = votersValid;
    }

    public Integer getVotersAmount() {
        return votersAmount;
    }

    public void setVotersAmount(Integer votersAmount) {
        this.votersAmount = votersAmount;
    }

    public Integer getCardsValid() {
        return cardsValid;
    }

    public void setCardsValid(Integer cardsValid) {
        this.cardsValid = cardsValid;
    }

    public Integer getVotesInvalid() {
        return votesInvalid;
    }

    public void setVotesInvalid(Integer votesInvalid) {
        this.votesInvalid = votesInvalid;
    }

    public Integer getVotesValid() {
        return votesValid;
    }

    public void setVotesValid(Integer votesValid) {
        this.votesValid = votesValid;
    }

    public String getFileOriginal() {
        return fileOriginal;
    }

    public void setFileOriginal(String fileOriginal) {
        this.fileOriginal = fileOriginal;
    }

    public OpwObwodowaKomisja getOpwObwodowaKomisjaId() {
        return opwObwodowaKomisjaId;
    }

    public void setOpwObwodowaKomisjaId(OpwObwodowaKomisja opwObwodowaKomisjaId) {
        this.opwObwodowaKomisjaId = opwObwodowaKomisjaId;
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
        if (!(object instanceof OpwWynik)) {
            return false;
        }
        OpwWynik other = (OpwWynik) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.adamkowalewski.opw.entity.OpwWynik[ id=" + id + " ]";
    }
    
}
