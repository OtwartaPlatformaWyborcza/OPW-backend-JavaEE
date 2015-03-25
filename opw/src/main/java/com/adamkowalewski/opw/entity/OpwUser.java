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
@Table(name = "opw_user", catalog = "opw", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OpwUser.findAll", query = "SELECT o FROM OpwUser o"),
    @NamedQuery(name = "OpwUser.findById", query = "SELECT o FROM OpwUser o WHERE o.id = :id"),
    @NamedQuery(name = "OpwUser.findByFirstname", query = "SELECT o FROM OpwUser o WHERE o.firstname = :firstname"),
    @NamedQuery(name = "OpwUser.findByLastname", query = "SELECT o FROM OpwUser o WHERE o.lastname = :lastname"),
    @NamedQuery(name = "OpwUser.findByEmail", query = "SELECT o FROM OpwUser o WHERE o.email = :email"),
    @NamedQuery(name = "OpwUser.findByPassword", query = "SELECT o FROM OpwUser o WHERE o.password = :password"),
    @NamedQuery(name = "OpwUser.findByType", query = "SELECT o FROM OpwUser o WHERE o.type = :type"),
    @NamedQuery(name = "OpwUser.findBySalt", query = "SELECT o FROM OpwUser o WHERE o.salt = :salt"),
    @NamedQuery(name = "OpwUser.findByActive", query = "SELECT o FROM OpwUser o WHERE o.active = :active"),
    @NamedQuery(name = "OpwUser.findByToken", query = "SELECT o FROM OpwUser o WHERE o.token = :token")})
public class OpwUser implements Serializable {
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 32)
    @Column(name = "phone", length = 32)
    private String phone;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Size(max = 64)
    @Column(name = "firstname", length = 64)
    private String firstname;
    @Size(max = 64)
    @Column(name = "lastname", length = 64)
    private String lastname;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 64)
    @Column(name = "email", length = 64)
    private String email;
    @Size(max = 64)
    @Column(name = "password", length = 64)
    private String password;
    @Size(max = 64)
    @Column(name = "type", length = 64)
    private String type;
    @Size(max = 32)
    @Column(name = "salt", length = 32)
    private String salt;
    @Column(name = "active")
    private Boolean active;
    @Size(max = 32)
    @Column(name = "token", length = 32)
    private String token;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "opwUserId")
    private List<OpwWynik> opwWynikList;

    public OpwUser() {
    }

    public OpwUser(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @XmlTransient
    public List<OpwWynik> getOpwWynikList() {
        return opwWynikList;
    }

    public void setOpwWynikList(List<OpwWynik> opwWynikList) {
        this.opwWynikList = opwWynikList;
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
        if (!(object instanceof OpwUser)) {
            return false;
        }
        OpwUser other = (OpwUser) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.adamkowalewski.opw.entity.OpwUser[ id=" + id + " ]";
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
}
