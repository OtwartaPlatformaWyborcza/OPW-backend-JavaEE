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
@Table(name = "opw_kandydat", catalog = "opw", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OpwKandydat.findAll", query = "SELECT o FROM OpwKandydat o"),
    @NamedQuery(name = "OpwKandydat.findAllOrderByPkwId", query = "SELECT o FROM OpwKandydat o ORDER BY o.pkwId ASC"),
    @NamedQuery(name = "OpwKandydat.findById", query = "SELECT o FROM OpwKandydat o WHERE o.id = :id"),
    @NamedQuery(name = "OpwKandydat.findByPkwId", query = "SELECT o FROM OpwKandydat o WHERE o.pkwId = :pkwId"),
    @NamedQuery(name = "OpwKandydat.findByFirstname", query = "SELECT o FROM OpwKandydat o WHERE o.firstname = :firstname"),
    @NamedQuery(name = "OpwKandydat.findByLastname", query = "SELECT o FROM OpwKandydat o WHERE o.lastname = :lastname")})
public class OpwKandydat implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "pkwId")
    private Integer pkwId;
    @Size(max = 128)
    @Column(name = "firstname", length = 128)
    private String firstname;
    @Size(max = 64)
    @Column(name = "lastname", length = 64)
    private String lastname;

    public OpwKandydat() {
    }

    public OpwKandydat(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPkwId() {
        return pkwId;
    }

    public void setPkwId(Integer pkwId) {
        this.pkwId = pkwId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
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
        if (!(object instanceof OpwKandydat)) {
            return false;
        }
        OpwKandydat other = (OpwKandydat) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.adamkowalewski.opw.entity.OpwKandydat[ id=" + id + " ]";
    }
    
}
