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
@Table(name = "TIPO_MOD_CONTRATTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoModContratto.findAll", query = "SELECT t FROM TipoModContratto t")
    , @NamedQuery(name = "TipoModContratto.findById", query = "SELECT t FROM TipoModContratto t WHERE t.id = :id")
    , @NamedQuery(name = "TipoModContratto.findByTipoModContratto", query = "SELECT t FROM TipoModContratto t WHERE t.tipoModContratto = :tipoModContratto")})
public class TipoModContratto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "TIPO_MOD_CONTRATTO")
    private String tipoModContratto;
    @OneToMany(mappedBy = "idTipoModContratto")
    private Collection<ActiveContrattiSediCliente> activeContrattiSediClienteCollection;

    public TipoModContratto() {
    }

    public TipoModContratto(Integer id) {
        this.id = id;
    }

    public TipoModContratto(Integer id, String tipoModContratto) {
        this.id = id;
        this.tipoModContratto = tipoModContratto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipoModContratto() {
        return tipoModContratto;
    }

    public void setTipoModContratto(String tipoModContratto) {
        this.tipoModContratto = tipoModContratto;
    }

    @XmlTransient
    public Collection<ActiveContrattiSediCliente> getActiveContrattiSediClienteCollection() {
        return activeContrattiSediClienteCollection;
    }

    public void setActiveContrattiSediClienteCollection(Collection<ActiveContrattiSediCliente> activeContrattiSediClienteCollection) {
        this.activeContrattiSediClienteCollection = activeContrattiSediClienteCollection;
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
        if (!(object instanceof TipoModContratto)) {
            return false;
        }
        TipoModContratto other = (TipoModContratto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "it.carvin.carvinwebappjpa.TipoModContratto[ id=" + id + " ]";
    }
    
}
