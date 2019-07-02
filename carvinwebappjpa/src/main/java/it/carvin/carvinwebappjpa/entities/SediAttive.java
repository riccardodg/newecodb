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
@Table(name = "SEDI_ATTIVE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SediAttive.findAll", query = "SELECT s FROM SediAttive s")
    , @NamedQuery(name = "SediAttive.findById", query = "SELECT s FROM SediAttive s WHERE s.id = :id")
    , @NamedQuery(name = "SediAttive.findByCodicesede", query = "SELECT s FROM SediAttive s WHERE s.codicesede = :codicesede")
    , @NamedQuery(name = "SediAttive.findByDataIni", query = "SELECT s FROM SediAttive s WHERE s.dataIni = :dataIni")
    , @NamedQuery(name = "SediAttive.findByDataFin", query = "SELECT s FROM SediAttive s WHERE s.dataFin = :dataFin")})
public class SediAttive implements Serializable {

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
    @Column(name = "CODICESEDE")
    private String codicesede;
    @Column(name = "DATA_INI")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataIni;
    @Column(name = "DATA_FIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataFin;
    @ManyToMany(mappedBy = "sediAttiveCollection")
    private Collection<Geografia> geografiaCollection;
    @ManyToMany(mappedBy = "sediAttiveCollection")
    private Collection<ActiveClients> activeClientsCollection;
    @ManyToMany(mappedBy = "sediAttiveCollection")
    private Collection<ContattiAttivi> contattiAttiviCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sediAttive")
    private Collection<ActiveContrattiSediCliente> activeContrattiSediClienteCollection;
    @JoinColumn(name = "ID_TIPO_SEDE", referencedColumnName = "ID")
    @ManyToOne
    private TipoSede idTipoSede;
    @JoinColumn(name = "ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Sedi sedi;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSedeA")
    private Collection<HisSedi> hisSediCollection;

    public SediAttive() {
    }

    public SediAttive(String id) {
        this.id = id;
    }

    public SediAttive(String id, String codicesede) {
        this.id = id;
        this.codicesede = codicesede;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCodicesede() {
        return codicesede;
    }

    public void setCodicesede(String codicesede) {
        this.codicesede = codicesede;
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
    public Collection<Geografia> getGeografiaCollection() {
        return geografiaCollection;
    }

    public void setGeografiaCollection(Collection<Geografia> geografiaCollection) {
        this.geografiaCollection = geografiaCollection;
    }

    @XmlTransient
    public Collection<ActiveClients> getActiveClientsCollection() {
        return activeClientsCollection;
    }

    public void setActiveClientsCollection(Collection<ActiveClients> activeClientsCollection) {
        this.activeClientsCollection = activeClientsCollection;
    }

    @XmlTransient
    public Collection<ContattiAttivi> getContattiAttiviCollection() {
        return contattiAttiviCollection;
    }

    public void setContattiAttiviCollection(Collection<ContattiAttivi> contattiAttiviCollection) {
        this.contattiAttiviCollection = contattiAttiviCollection;
    }

    @XmlTransient
    public Collection<ActiveContrattiSediCliente> getActiveContrattiSediClienteCollection() {
        return activeContrattiSediClienteCollection;
    }

    public void setActiveContrattiSediClienteCollection(Collection<ActiveContrattiSediCliente> activeContrattiSediClienteCollection) {
        this.activeContrattiSediClienteCollection = activeContrattiSediClienteCollection;
    }

    public TipoSede getIdTipoSede() {
        return idTipoSede;
    }

    public void setIdTipoSede(TipoSede idTipoSede) {
        this.idTipoSede = idTipoSede;
    }

    public Sedi getSedi() {
        return sedi;
    }

    public void setSedi(Sedi sedi) {
        this.sedi = sedi;
    }

    @XmlTransient
    public Collection<HisSedi> getHisSediCollection() {
        return hisSediCollection;
    }

    public void setHisSediCollection(Collection<HisSedi> hisSediCollection) {
        this.hisSediCollection = hisSediCollection;
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
        if (!(object instanceof SediAttive)) {
            return false;
        }
        SediAttive other = (SediAttive) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "it.carvin.carvinwebappjpa.SediAttive[ id=" + id + " ]";
    }
    
}
