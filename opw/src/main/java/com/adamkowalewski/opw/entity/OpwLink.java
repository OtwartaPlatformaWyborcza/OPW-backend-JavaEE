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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Adam Kowalewski
 */
@Entity
@Table(name = "opw_link", catalog = "opw", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OpwLink.findAll", query = "SELECT o FROM OpwLink o"),
    @NamedQuery(name = "OpwLink.findById", query = "SELECT o FROM OpwLink o WHERE o.id = :id"),
    @NamedQuery(name = "OpwLink.findByLabel", query = "SELECT o FROM OpwLink o WHERE o.label = :label"),
    @NamedQuery(name = "OpwLink.findByUrl", query = "SELECT o FROM OpwLink o WHERE o.url = :url"),
    @NamedQuery(name = "OpwLink.findByComment", query = "SELECT o FROM OpwLink o WHERE o.comment = :comment"),
    @NamedQuery(name = "OpwLink.findByActive", query = "SELECT o FROM OpwLink o WHERE o.active = :active"),
    @NamedQuery(name = "OpwLink.findByDateCreated", query = "SELECT o FROM OpwLink o WHERE o.dateCreated = :dateCreated")})
public class OpwLink implements Serializable {
    @Column(name = "dateCreated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Size(max = 128)
    @Column(name = "label", length = 128)
    private String label;
    @Size(max = 256)
    @Column(name = "url", length = 256)
    private String url;
    @Size(max = 256)
    @Column(name = "comment", length = 256)
    private String comment;
    @Column(name = "active")
    private Boolean active;
    @JoinColumn(name = "opw_user_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private OpwUser opwUserId;
    @JoinColumn(name = "opw_wynik_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private OpwWynik opwWynikId;

    public OpwLink() {
    }

    public OpwLink(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }


    public OpwUser getOpwUserId() {
        return opwUserId;
    }

    public void setOpwUserId(OpwUser opwUserId) {
        this.opwUserId = opwUserId;
    }

    public OpwWynik getOpwWynikId() {
        return opwWynikId;
    }

    public void setOpwWynikId(OpwWynik opwWynikId) {
        this.opwWynikId = opwWynikId;
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
        if (!(object instanceof OpwLink)) {
            return false;
        }
        OpwLink other = (OpwLink) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.adamkowalewski.opw.entity.OpwLink[ id=" + id + " ]";
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }
    
}
