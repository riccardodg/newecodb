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
@Table(name = "TIPO_CONTRATTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoContratto.findAll", query = "SELECT t FROM TipoContratto t")
    , @NamedQuery(name = "TipoContratto.findById", query = "SELECT t FROM TipoContratto t WHERE t.id = :id")
    , @NamedQuery(name = "TipoContratto.findByTipoContratto", query = "SELECT t FROM TipoContratto t WHERE t.tipoContratto = :tipoContratto")})
public class TipoContratto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "TIPO_CONTRATTO")
    private String tipoContratto;
    @OneToMany(mappedBy = "idTipoContratto")
    private Collection<Contracts> contractsCollection;
    @OneToMany(mappedBy = "idTipoContratto")
    private Collection<ActiveContracts> activeContractsCollection;

    public TipoContratto() {
    }

    public TipoContratto(Integer id) {
        this.id = id;
    }

    public TipoContratto(Integer id, String tipoContratto) {
        this.id = id;
        this.tipoContratto = tipoContratto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipoContratto() {
        return tipoContratto;
    }

    public void setTipoContratto(String tipoContratto) {
        this.tipoContratto = tipoContratto;
    }

    @XmlTransient
    public Collection<Contracts> getContractsCollection() {
        return contractsCollection;
    }

    public void setContractsCollection(Collection<Contracts> contractsCollection) {
        this.contractsCollection = contractsCollection;
    }

    @XmlTransient
    public Collection<ActiveContracts> getActiveContractsCollection() {
        return activeContractsCollection;
    }

    public void setActiveContractsCollection(Collection<ActiveContracts> activeContractsCollection) {
        this.activeContractsCollection = activeContractsCollection;
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
        if (!(object instanceof TipoContratto)) {
            return false;
        }
        TipoContratto other = (TipoContratto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "it.carvin.carvinwebappjpa.TipoContratto[ id=" + id + " ]";
    }
    
}
