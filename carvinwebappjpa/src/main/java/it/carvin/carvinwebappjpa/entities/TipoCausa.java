/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.carvin.carvinwebappjpa.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Riccardo Del Gratta &lt;riccardo.delgratta@ilc.cnr.it&gt;
 */
@Entity
@Table(name = "TIPO_CAUSA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoCausa.findAll", query = "SELECT t FROM TipoCausa t")
    , @NamedQuery(name = "TipoCausa.findById", query = "SELECT t FROM TipoCausa t WHERE t.id = :id")
    , @NamedQuery(name = "TipoCausa.findByCausa", query = "SELECT t FROM TipoCausa t WHERE t.causa = :causa")})
public class TipoCausa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "CAUSA")
    private String causa;
    @OneToMany(mappedBy = "idCausa")
    private Collection<Contracts> contractsCollection;
    @OneToMany(mappedBy = "idCausa")
    private Collection<Contatti> contattiCollection;
    @OneToMany(mappedBy = "idCausa")
    private Collection<Sedi> sediCollection;
    @OneToMany(mappedBy = "idCausa")
    private Collection<Clients> clientsCollection;

    public TipoCausa() {
    }

    public TipoCausa(Integer id) {
        this.id = id;
    }

    public TipoCausa(Integer id, String causa) {
        this.id = id;
        this.causa = causa;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCausa() {
        return causa;
    }

    public void setCausa(String causa) {
        this.causa = causa;
    }

    @XmlTransient
    public Collection<Contracts> getContractsCollection() {
        return contractsCollection;
    }

    public void setContractsCollection(Collection<Contracts> contractsCollection) {
        this.contractsCollection = contractsCollection;
    }

    @XmlTransient
    public Collection<Contatti> getContattiCollection() {
        return contattiCollection;
    }

    public void setContattiCollection(Collection<Contatti> contattiCollection) {
        this.contattiCollection = contattiCollection;
    }

    @XmlTransient
    public Collection<Sedi> getSediCollection() {
        return sediCollection;
    }

    public void setSediCollection(Collection<Sedi> sediCollection) {
        this.sediCollection = sediCollection;
    }

    @XmlTransient
    public Collection<Clients> getClientsCollection() {
        return clientsCollection;
    }

    public void setClientsCollection(Collection<Clients> clientsCollection) {
        this.clientsCollection = clientsCollection;
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
        if (!(object instanceof TipoCausa)) {
            return false;
        }
        TipoCausa other = (TipoCausa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "it.carvin.carvinwebappjpa.TipoCausa[ id=" + id + " ]";
    }
    
}
