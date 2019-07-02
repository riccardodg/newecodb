/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.carvin.carvinwebappjpa.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Riccardo Del Gratta &lt;riccardo.delgratta@ilc.cnr.it&gt;
 */
@Entity
@Table(name = "ACTIVE_CONTRACTS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ActiveContracts.findAll", query = "SELECT a FROM ActiveContracts a")
    , @NamedQuery(name = "ActiveContracts.findById", query = "SELECT a FROM ActiveContracts a WHERE a.id = :id")
    , @NamedQuery(name = "ActiveContracts.findByCodicecontratto", query = "SELECT a FROM ActiveContracts a WHERE a.codicecontratto = :codicecontratto")
    , @NamedQuery(name = "ActiveContracts.findByDataIni", query = "SELECT a FROM ActiveContracts a WHERE a.dataIni = :dataIni")
    , @NamedQuery(name = "ActiveContracts.findByDataFin", query = "SELECT a FROM ActiveContracts a WHERE a.dataFin = :dataFin")})
public class ActiveContracts implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ID")
    private String id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "CODICECONTRATTO")
    private String codicecontratto;
    @Column(name = "DATA_INI")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataIni;
    @Column(name = "DATA_FIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataFin;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "activeContracts")
    private AnagraficaContratti anagraficaContratti;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "activeContracts")
    private Collection<ActiveContrattiSediCliente> activeContrattiSediClienteCollection;
    @JoinColumn(name = "ID_TIPO_CONTRATTO", referencedColumnName = "ID")
    @ManyToOne
    private TipoContratto idTipoContratto;
    @JoinColumn(name = "ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Contracts contracts;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idContrattoA")
    private Collection<HisContracts> hisContractsCollection;

    public ActiveContracts() {
    }

    public ActiveContracts(String id) {
        this.id = id;
    }

    public ActiveContracts(String id, String codicecontratto) {
        this.id = id;
        this.codicecontratto = codicecontratto;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCodicecontratto() {
        return codicecontratto;
    }

    public void setCodicecontratto(String codicecontratto) {
        this.codicecontratto = codicecontratto;
    }

    public Date getDataIni() {
        return dataIni;
    }

    public void setDataIni(Date dataIni) {
        this.dataIni = dataIni;
    }

    public Date getDataFin() {
        return dataFin;
    }

    public void setDataFin(Date dataFin) {
        this.dataFin = dataFin;
    }

    public AnagraficaContratti getAnagraficaContratti() {
        return anagraficaContratti;
    }

    public void setAnagraficaContratti(AnagraficaContratti anagraficaContratti) {
        this.anagraficaContratti = anagraficaContratti;
    }

    @XmlTransient
    public Collection<ActiveContrattiSediCliente> getActiveContrattiSediClienteCollection() {
        return activeContrattiSediClienteCollection;
    }

    public void setActiveContrattiSediClienteCollection(Collection<ActiveContrattiSediCliente> activeContrattiSediClienteCollection) {
        this.activeContrattiSediClienteCollection = activeContrattiSediClienteCollection;
    }

    public TipoContratto getIdTipoContratto() {
        return idTipoContratto;
    }

    public void setIdTipoContratto(TipoContratto idTipoContratto) {
        this.idTipoContratto = idTipoContratto;
    }

    public Contracts getContracts() {
        return contracts;
    }

    public void setContracts(Contracts contracts) {
        this.contracts = contracts;
    }

    @XmlTransient
    public Collection<HisContracts> getHisContractsCollection() {
        return hisContractsCollection;
    }

    public void setHisContractsCollection(Collection<HisContracts> hisContractsCollection) {
        this.hisContractsCollection = hisContractsCollection;
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
        if (!(object instanceof ActiveContracts)) {
            return false;
        }
        ActiveContracts other = (ActiveContracts) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "it.carvin.carvinwebappjpa.ActiveContracts[ id=" + id + " ]";
    }
    
}
