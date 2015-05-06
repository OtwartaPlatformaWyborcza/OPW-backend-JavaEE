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
@Table(name = "opw_wojewodztwo", catalog = "opw", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OpwWojewodztwo.findAll", query = "SELECT o FROM OpwWojewodztwo o"),
    @NamedQuery(name = "OpwWojewodztwo.findById", query = "SELECT o FROM OpwWojewodztwo o WHERE o.id = :id"),
    @NamedQuery(name = "OpwWojewodztwo.findByName", query = "SELECT o FROM OpwWojewodztwo o WHERE o.name = :name"),
    @NamedQuery(name = "OpwWojewodztwo.findByTeryt", query = "SELECT o FROM OpwWojewodztwo o WHERE o.teryt = :teryt")})
public class OpwWojewodztwo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Size(max = 64)
    @Column(name = "name", length = 64)
    private String name;
    @Size(max = 2)
    @Column(name = "teryt", length = 2)
    private String teryt;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "opwWojewodztwoId")
    private List<OpwOkregowaKomisja> opwOkregowaKomisjaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "opwWojewodztwoId")
    private List<OpwObwodowaKomisja> opwObwodowaKomisjaList;

    public OpwWojewodztwo() {
    }

    public OpwWojewodztwo(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeryt() {
        return teryt;
    }

    public void setTeryt(String teryt) {
        this.teryt = teryt;
    }

    @XmlTransient
    public List<OpwOkregowaKomisja> getOpwOkregowaKomisjaList() {
        return opwOkregowaKomisjaList;
    }

    public void setOpwOkregowaKomisjaList(List<OpwOkregowaKomisja> opwOkregowaKomisjaList) {
        this.opwOkregowaKomisjaList = opwOkregowaKomisjaList;
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
        if (!(object instanceof OpwWojewodztwo)) {
            return false;
        }
        OpwWojewodztwo other = (OpwWojewodztwo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.adamkowalewski.opw.entity.OpwWojewodztwo[ id=" + id + " ]";
    }
    
}
