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
import java.util.Date;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

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
    @NamedQuery(name = "OpwWynik.findByFileOriginal", query = "SELECT o FROM OpwWynik o WHERE o.fileOriginal = :fileOriginal"),
    @NamedQuery(name = "OpwWynik.findByActive", query = "SELECT o FROM OpwWynik o WHERE o.active = :active"),
    @NamedQuery(name = "OpwWynik.findByDateCreated", query = "SELECT o FROM OpwWynik o WHERE o.dateCreated = :dateCreated"),
    @NamedQuery(name = "OpwWynik.findByK1", query = "SELECT o FROM OpwWynik o WHERE o.k1 = :k1"),
    @NamedQuery(name = "OpwWynik.findByK2", query = "SELECT o FROM OpwWynik o WHERE o.k2 = :k2"),
    @NamedQuery(name = "OpwWynik.findByK3", query = "SELECT o FROM OpwWynik o WHERE o.k3 = :k3"),
    @NamedQuery(name = "OpwWynik.findByK4", query = "SELECT o FROM OpwWynik o WHERE o.k4 = :k4"),
    @NamedQuery(name = "OpwWynik.findByK5", query = "SELECT o FROM OpwWynik o WHERE o.k5 = :k5"),
    @NamedQuery(name = "OpwWynik.findByK6", query = "SELECT o FROM OpwWynik o WHERE o.k6 = :k6"),
    @NamedQuery(name = "OpwWynik.findByK7", query = "SELECT o FROM OpwWynik o WHERE o.k7 = :k7"),
    @NamedQuery(name = "OpwWynik.findByK8", query = "SELECT o FROM OpwWynik o WHERE o.k8 = :k8"),
    @NamedQuery(name = "OpwWynik.findByK9", query = "SELECT o FROM OpwWynik o WHERE o.k9 = :k9"),
    @NamedQuery(name = "OpwWynik.findByK10", query = "SELECT o FROM OpwWynik o WHERE o.k10 = :k10"),
    @NamedQuery(name = "OpwWynik.findByK11", query = "SELECT o FROM OpwWynik o WHERE o.k11 = :k11"),
    @NamedQuery(name = "OpwWynik.findByRatedPositiv", query = "SELECT o FROM OpwWynik o WHERE o.ratedPositiv = :ratedPositiv"),
    @NamedQuery(name = "OpwWynik.findByRatedNegativ", query = "SELECT o FROM OpwWynik o WHERE o.ratedNegativ = :ratedNegativ"),
    @NamedQuery(name = "OpwWynik.findByStatus", query = "SELECT o FROM OpwWynik o WHERE o.status = :status")})
public class OpwWynik implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "votersValid")
    private Short votersValid;
    @Column(name = "votersAmount")
    private Short votersAmount;
    @Column(name = "cardsValid")
    private Short cardsValid;
    @Column(name = "votesInvalid")
    private Short votesInvalid;
    @Column(name = "votesValid")
    private Short votesValid;
    @Size(max = 128)
    @Column(name = "fileOriginal", length = 128)
    private String fileOriginal;
    @Column(name = "active")
    private Boolean active;
    @Column(name = "dateCreated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;
    @Column(name = "k1")
    private Short k1;
    @Column(name = "k2")
    private Short k2;
    @Column(name = "k3")
    private Short k3;
    @Column(name = "k4")
    private Short k4;
    @Column(name = "k5")
    private Short k5;
    @Column(name = "k6")
    private Short k6;
    @Column(name = "k7")
    private Short k7;
    @Column(name = "k8")
    private Short k8;
    @Column(name = "k9")
    private Short k9;
    @Column(name = "k10")
    private Short k10;
    @Column(name = "k11")
    private Short k11;
    @Column(name = "ratedPositiv")
    private Integer ratedPositiv;
    @Column(name = "ratedNegativ")
    private Integer ratedNegativ;
    @Column(name = "status")
    private Integer status;
    @JoinColumn(name = "opw_user_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private OpwUser opwUserId;
    @OneToMany(mappedBy = "parentId")
    private List<OpwWynik> opwWynikList;
    @JoinColumn(name = "parentId", referencedColumnName = "id")
    @ManyToOne
    private OpwWynik parentId;
    @JoinColumn(name = "opw_obwodowa_komisja_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private OpwObwodowaKomisja opwObwodowaKomisjaId;

    public OpwWynik() {
    }

    public OpwWynik(Short votersValid, Short votersAmount, Short cardsValid, Short votesInvalid, Short votesValid, String fileOriginal, Boolean active, Date dateCreated, Short k1, Short k2, Short k3, Short k4, Short k5, Short k6, Short k7, Short k8, Short k9, Short k10, Short k11, Integer ratedPositiv, Integer ratedNegativ, Integer status, OpwUser opwUserId, List<OpwWynik> opwWynikList, OpwWynik parentId, OpwObwodowaKomisja opwObwodowaKomisjaId) {
        this.votersValid = votersValid;
        this.votersAmount = votersAmount;
        this.cardsValid = cardsValid;
        this.votesInvalid = votesInvalid;
        this.votesValid = votesValid;
        this.fileOriginal = fileOriginal;
        this.active = active;
        this.dateCreated = dateCreated;
        this.k1 = k1;
        this.k2 = k2;
        this.k3 = k3;
        this.k4 = k4;
        this.k5 = k5;
        this.k6 = k6;
        this.k7 = k7;
        this.k8 = k8;
        this.k9 = k9;
        this.k10 = k10;
        this.k11 = k11;
        this.ratedPositiv = ratedPositiv;
        this.ratedNegativ = ratedNegativ;
        this.status = status;
        this.opwUserId = opwUserId;
        this.opwWynikList = opwWynikList;
        this.parentId = parentId;
        this.opwObwodowaKomisjaId = opwObwodowaKomisjaId;
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

    public Short getVotersValid() {
        return votersValid;
    }

    public void setVotersValid(Short votersValid) {
        this.votersValid = votersValid;
    }

    public Short getVotersAmount() {
        return votersAmount;
    }

    public void setVotersAmount(Short votersAmount) {
        this.votersAmount = votersAmount;
    }

    public Short getCardsValid() {
        return cardsValid;
    }

    public void setCardsValid(Short cardsValid) {
        this.cardsValid = cardsValid;
    }

    public Short getVotesInvalid() {
        return votesInvalid;
    }

    public void setVotesInvalid(Short votesInvalid) {
        this.votesInvalid = votesInvalid;
    }

    public Short getVotesValid() {
        return votesValid;
    }

    public void setVotesValid(Short votesValid) {
        this.votesValid = votesValid;
    }

    public String getFileOriginal() {
        return fileOriginal;
    }

    public void setFileOriginal(String fileOriginal) {
        this.fileOriginal = fileOriginal;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
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

    public Short getK3() {
        return k3;
    }

    public void setK3(Short k3) {
        this.k3 = k3;
    }

    public Short getK4() {
        return k4;
    }

    public void setK4(Short k4) {
        this.k4 = k4;
    }

    public Short getK5() {
        return k5;
    }

    public void setK5(Short k5) {
        this.k5 = k5;
    }

    public Short getK6() {
        return k6;
    }

    public void setK6(Short k6) {
        this.k6 = k6;
    }

    public Short getK7() {
        return k7;
    }

    public void setK7(Short k7) {
        this.k7 = k7;
    }

    public Short getK8() {
        return k8;
    }

    public void setK8(Short k8) {
        this.k8 = k8;
    }

    public Short getK9() {
        return k9;
    }

    public void setK9(Short k9) {
        this.k9 = k9;
    }

    public Short getK10() {
        return k10;
    }

    public void setK10(Short k10) {
        this.k10 = k10;
    }

    public Short getK11() {
        return k11;
    }

    public void setK11(Short k11) {
        this.k11 = k11;
    }

    public Integer getRatedPositiv() {
        return ratedPositiv;
    }

    public void setRatedPositiv(Integer ratedPositiv) {
        this.ratedPositiv = ratedPositiv;
    }

    public Integer getRatedNegativ() {
        return ratedNegativ;
    }

    public void setRatedNegativ(Integer ratedNegativ) {
        this.ratedNegativ = ratedNegativ;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public OpwUser getOpwUserId() {
        return opwUserId;
    }

    public void setOpwUserId(OpwUser opwUserId) {
        this.opwUserId = opwUserId;
    }

    @XmlTransient
    public List<OpwWynik> getOpwWynikList() {
        return opwWynikList;
    }

    public void setOpwWynikList(List<OpwWynik> opwWynikList) {
        this.opwWynikList = opwWynikList;
    }

    public OpwWynik getParentId() {
        return parentId;
    }

    public void setParentId(OpwWynik parentId) {
        this.parentId = parentId;
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
