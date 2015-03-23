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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Adam Kowalewski
 */
@Entity
@Table(name = "opw_okregowa_komisja", catalog = "opw", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OpwOkregowaKomisja.findAll", query = "SELECT o FROM OpwOkregowaKomisja o"),
    @NamedQuery(name = "OpwOkregowaKomisja.findById", query = "SELECT o FROM OpwOkregowaKomisja o WHERE o.id = :id"),
    @NamedQuery(name = "OpwOkregowaKomisja.findByPkwId", query = "SELECT o FROM OpwOkregowaKomisja o WHERE o.pkwId = :pkwId"),
    @NamedQuery(name = "OpwOkregowaKomisja.findByName", query = "SELECT o FROM OpwOkregowaKomisja o WHERE o.name = :name"),
    @NamedQuery(name = "OpwOkregowaKomisja.findByAddress", query = "SELECT o FROM OpwOkregowaKomisja o WHERE o.address = :address")})
public class OpwOkregowaKomisja implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Size(max = 64)
    @Column(name = "pkwId", length = 64)
    private String pkwId;
    @Size(max = 128)
    @Column(name = "name", length = 128)
    private String name;
    @Size(max = 128)
    @Column(name = "address", length = 128)
    private String address;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "opwOkregowaKomisjaId")
    private List<OpwObwodowaKomisja> opwObwodowaKomisjaList;

    public OpwOkregowaKomisja() {
    }

    public OpwOkregowaKomisja(Integer id) {
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

    @XmlTransient
    public List<OpwObwodowaKomisja> getOpwObwodowaKomisjaList() {
        return opwObwodowaKomisjaList;
    }

    public void setOpwObwodowaKomisjaList(List<OpwObwodowaKomisja> opwObwodowaKomisjaList) {
        this.opwObwodowaKomisjaList = opwObwodowaKomisjaList;
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
        if (!(object instanceof OpwOkregowaKomisja)) {
            return false;
        }
        OpwOkregowaKomisja other = (OpwOkregowaKomisja) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.adamkowalewski.opw.entity.OpwOkregowaKomisja[ id=" + id + " ]";
    }
    
}
