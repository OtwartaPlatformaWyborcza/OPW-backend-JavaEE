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
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Adam Kowalewski
 */
@Entity
@Table(name = "opw_obwodowa_komisja", catalog = "opw", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"pkwId"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OpwObwodowaKomisja.findAll", query = "SELECT o FROM OpwObwodowaKomisja o"),
    @NamedQuery(name = "OpwObwodowaKomisja.findById", query = "SELECT o FROM OpwObwodowaKomisja o WHERE o.id = :id"),
    @NamedQuery(name = "OpwObwodowaKomisja.findByPkwId", query = "SELECT o FROM OpwObwodowaKomisja o WHERE o.pkwId = :pkwId"),
    @NamedQuery(name = "OpwObwodowaKomisja.findByObwodNr", query = "SELECT o FROM OpwObwodowaKomisja o WHERE o.obwodNr = :obwodNr"),
    @NamedQuery(name = "OpwObwodowaKomisja.findByName", query = "SELECT o FROM OpwObwodowaKomisja o WHERE o.name = :name"),
    @NamedQuery(name = "OpwObwodowaKomisja.findByAddress", query = "SELECT o FROM OpwObwodowaKomisja o WHERE o.address = :address"),
    @NamedQuery(name = "OpwObwodowaKomisja.findByType", query = "SELECT o FROM OpwObwodowaKomisja o WHERE o.type = :type"),
    @NamedQuery(name = "OpwObwodowaKomisja.findByAllowedToVote", query = "SELECT o FROM OpwObwodowaKomisja o WHERE o.allowedToVote = :allowedToVote")})
public class OpwObwodowaKomisja implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Size(max = 64)
    @Column(name = "pkwId", length = 64)
    private String pkwId;
    @Column(name = "obwodNr")
    private Integer obwodNr;
    @Size(max = 256)
    @Column(name = "name", length = 256)
    private String name;
    @Size(max = 256)
    @Column(name = "address", length = 256)
    private String address;
    @Size(max = 4)
    @Column(name = "type", length = 4)
    private String type;
    @Column(name = "allowedToVote")
    private Integer allowedToVote;
    @JoinTable(name = "opw_user_has_opw_obwodowa_komisja", joinColumns = {
        @JoinColumn(name = "opw_obwodowa_komisja_id", referencedColumnName = "id", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "opw_user_id", referencedColumnName = "id", nullable = false)})
    @ManyToMany
    private List<OpwUser> opwUserList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "opwObwodowaKomisjaId")
    private List<OpwWynik> opwWynikList;
    @JoinColumn(name = "opw_okregowa_komisja_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private OpwOkregowaKomisja opwOkregowaKomisjaId;

    public OpwObwodowaKomisja() {
    }

    public OpwObwodowaKomisja(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPkwId() {
        return pkwId;
    }

    public void setPkwId(String pkwId) {
        this.pkwId = pkwId;
    }

    public Integer getObwodNr() {
        return obwodNr;
    }

    public void setObwodNr(Integer obwodNr) {
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

    public Integer getAllowedToVote() {
        return allowedToVote;
    }

    public void setAllowedToVote(Integer allowedToVote) {
        this.allowedToVote = allowedToVote;
    }

    @XmlTransient
    public List<OpwUser> getOpwUserList() {
        return opwUserList;
    }

    public void setOpwUserList(List<OpwUser> opwUserList) {
        this.opwUserList = opwUserList;
    }

    @XmlTransient
    public List<OpwWynik> getOpwWynikList() {
        return opwWynikList;
    }

    public void setOpwWynikList(List<OpwWynik> opwWynikList) {
        this.opwWynikList = opwWynikList;
    }

    public OpwOkregowaKomisja getOpwOkregowaKomisjaId() {
        return opwOkregowaKomisjaId;
    }

    public void setOpwOkregowaKomisjaId(OpwOkregowaKomisja opwOkregowaKomisjaId) {
        this.opwOkregowaKomisjaId = opwOkregowaKomisjaId;
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
        if (!(object instanceof OpwObwodowaKomisja)) {
            return false;
        }
        OpwObwodowaKomisja other = (OpwObwodowaKomisja) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.adamkowalewski.opw.entity.OpwObwodowaKomisja[ id=" + id + " ]";
    }
    
}
