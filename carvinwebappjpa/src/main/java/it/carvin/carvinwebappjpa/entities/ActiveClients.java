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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "ACTIVE_CLIENTS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ActiveClients.findAll", query = "SELECT a FROM ActiveClients a")
    , @NamedQuery(name = "ActiveClients.findById", query = "SELECT a FROM ActiveClients a WHERE a.id = :id")
    , @NamedQuery(name = "ActiveClients.findByCodicecliente", query = "SELECT a FROM ActiveClients a WHERE a.codicecliente = :codicecliente")
    , @NamedQuery(name = "ActiveClients.findByDataIni", query = "SELECT a FROM ActiveClients a WHERE a.dataIni = :dataIni")
    , @NamedQuery(name = "ActiveClients.findByDataFin", query = "SELECT a FROM ActiveClients a WHERE a.dataFin = :dataFin")})
public class ActiveClients implements Serializable {

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
    @Column(name = "CODICECLIENTE")
    private String codicecliente;
    @Column(name = "DATA_INI")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataIni;
    @Column(name = "DATA_FIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataFin;
    @JoinTable(name = "ACTIVE_CLIENTI_SEDI", joinColumns = {
        @JoinColumn(name = "ID_CLIENTE", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "ID_SEDE", referencedColumnName = "ID")})
    @ManyToMany
    private Collection<SediAttive> sediAttiveCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idClienteA")
    private Collection<HisClients> hisClientsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCliente")
    private Collection<ActiveContrattiSediCliente> activeContrattiSediClienteCollection;
    @OneToMany(mappedBy = "idPartner")
    private Collection<ActiveContrattiSediCliente> activeContrattiSediClienteCollection1;
    @JoinColumn(name = "ID_TIPO_CLIENTE", referencedColumnName = "ID")
    @ManyToOne
    private TipoCliente idTipoCliente;
    @JoinColumn(name = "ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Clients clients;

    public ActiveClients() {
    }

    public ActiveClients(String id) {
        this.id = id;
    }

    public ActiveClients(String id, String codicecliente) {
        this.id = id;
        this.codicecliente = codicecliente;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCodicecliente() {
        return codicecliente;
    }

    public void setCodicecliente(String codicecliente) {
        this.codicecliente = codicecliente;
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

    @XmlTransient
    public Collection<SediAttive> getSediAttiveCollection() {
        return sediAttiveCollection;
    }

    public void setSediAttiveCollection(Collection<SediAttive> sediAttiveCollection) {
        this.sediAttiveCollection = sediAttiveCollection;
    }

    @XmlTransient
    public Collection<HisClients> getHisClientsCollection() {
        return hisClientsCollection;
    }

    public void setHisClientsCollection(Collection<HisClients> hisClientsCollection) {
        this.hisClientsCollection = hisClientsCollection;
    }

    @XmlTransient
    public Collection<ActiveContrattiSediCliente> getActiveContrattiSediClienteCollection() {
        return activeContrattiSediClienteCollection;
    }

    public void setActiveContrattiSediClienteCollection(Collection<ActiveContrattiSediCliente> activeContrattiSediClienteCollection) {
        this.activeContrattiSediClienteCollection = activeContrattiSediClienteCollection;
    }

    @XmlTransient
    public Collection<ActiveContrattiSediCliente> getActiveContrattiSediClienteCollection1() {
        return activeContrattiSediClienteCollection1;
    }

    public void setActiveContrattiSediClienteCollection1(Collection<ActiveContrattiSediCliente> activeContrattiSediClienteCollection1) {
        this.activeContrattiSediClienteCollection1 = activeContrattiSediClienteCollection1;
    }

    public TipoCliente getIdTipoCliente() {
        return idTipoCliente;
    }

    public void setIdTipoCliente(TipoCliente idTipoCliente) {
        this.idTipoCliente = idTipoCliente;
    }

    public Clients getClients() {
        return clients;
    }

    public void setClients(Clients clients) {
        this.clients = clients;
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
        if (!(object instanceof ActiveClients)) {
            return false;
        }
        ActiveClients other = (ActiveClients) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "it.carvin.carvinwebappjpa.ActiveClients[ id=" + id + " ]";
    }
    
}
