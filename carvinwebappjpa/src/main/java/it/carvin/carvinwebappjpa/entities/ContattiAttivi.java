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
@Table(name = "CONTATTI_ATTIVI")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ContattiAttivi.findAll", query = "SELECT c FROM ContattiAttivi c")
    , @NamedQuery(name = "ContattiAttivi.findById", query = "SELECT c FROM ContattiAttivi c WHERE c.id = :id")
    , @NamedQuery(name = "ContattiAttivi.findByCodicecontatto", query = "SELECT c FROM ContattiAttivi c WHERE c.codicecontatto = :codicecontatto")
    , @NamedQuery(name = "ContattiAttivi.findByDataIni", query = "SELECT c FROM ContattiAttivi c WHERE c.dataIni = :dataIni")
    , @NamedQuery(name = "ContattiAttivi.findByDataFin", query = "SELECT c FROM ContattiAttivi c WHERE c.dataFin = :dataFin")})
public class ContattiAttivi implements Serializable {

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
    @Column(name = "CODICECONTATTO")
    private String codicecontatto;
    @Column(name = "DATA_INI")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataIni;
    @Column(name = "DATA_FIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataFin;
    @JoinTable(name = "ACTIVE_SEDI_CONTATTI", joinColumns = {
        @JoinColumn(name = "ID_CONTATTO", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "ID_SEDE", referencedColumnName = "ID")})
    @ManyToMany
    private Collection<SediAttive> sediAttiveCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contattiAttivi")
    private Collection<MansionarioContatto> mansionarioContattoCollection;
    @JoinColumn(name = "ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Contatti contatti;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contattiAttivi")
    private Collection<ValoreTipoContatto> valoreTipoContattoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idContattoA")
    private Collection<HisContatti> hisContattiCollection;

    public ContattiAttivi() {
    }

    public ContattiAttivi(String id) {
        this.id = id;
    }

    public ContattiAttivi(String id, String codicecontatto) {
        this.id = id;
        this.codicecontatto = codicecontatto;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCodicecontatto() {
        return codicecontatto;
    }

    public void setCodicecontatto(String codicecontatto) {
        this.codicecontatto = codicecontatto;
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
    public Collection<MansionarioContatto> getMansionarioContattoCollection() {
        return mansionarioContattoCollection;
    }

    public void setMansionarioContattoCollection(Collection<MansionarioContatto> mansionarioContattoCollection) {
        this.mansionarioContattoCollection = mansionarioContattoCollection;
    }

    public Contatti getContatti() {
        return contatti;
    }

    public void setContatti(Contatti contatti) {
        this.contatti = contatti;
    }

    @XmlTransient
    public Collection<ValoreTipoContatto> getValoreTipoContattoCollection() {
        return valoreTipoContattoCollection;
    }

    public void setValoreTipoContattoCollection(Collection<ValoreTipoContatto> valoreTipoContattoCollection) {
        this.valoreTipoContattoCollection = valoreTipoContattoCollection;
    }

    @XmlTransient
    public Collection<HisContatti> getHisContattiCollection() {
        return hisContattiCollection;
    }

    public void setHisContattiCollection(Collection<HisContatti> hisContattiCollection) {
        this.hisContattiCollection = hisContattiCollection;
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
        if (!(object instanceof ContattiAttivi)) {
            return false;
        }
        ContattiAttivi other = (ContattiAttivi) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "it.carvin.carvinwebappjpa.ContattiAttivi[ id=" + id + " ]";
    }
    
}
