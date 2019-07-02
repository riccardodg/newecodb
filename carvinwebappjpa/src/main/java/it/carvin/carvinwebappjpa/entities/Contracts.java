/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.carvin.carvinwebappjpa.entities;

import java.io.Serializable;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Riccardo Del Gratta &lt;riccardo.delgratta@ilc.cnr.it&gt;
 */
@Entity
@Table(name = "CONTRACTS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contracts.findAll", query = "SELECT c FROM Contracts c")
    , @NamedQuery(name = "Contracts.findById", query = "SELECT c FROM Contracts c WHERE c.id = :id")
    , @NamedQuery(name = "Contracts.findByCodicecontratto", query = "SELECT c FROM Contracts c WHERE c.codicecontratto = :codicecontratto")
    , @NamedQuery(name = "Contracts.findByDataIni", query = "SELECT c FROM Contracts c WHERE c.dataIni = :dataIni")
    , @NamedQuery(name = "Contracts.findByDataFin", query = "SELECT c FROM Contracts c WHERE c.dataFin = :dataFin")})
public class Contracts implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ID")
    private String id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "CODICECONTRATTO")
    private String codicecontratto;
    @Column(name = "DATA_INI")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataIni;
    @Column(name = "DATA_FIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataFin;
    @JoinColumn(name = "ID_CAUSA", referencedColumnName = "ID")
    @ManyToOne
    private TipoCausa idCausa;
    @JoinColumn(name = "ID_TIPO_CONTRATTO", referencedColumnName = "ID")
    @ManyToOne
    private TipoContratto idTipoContratto;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "contracts")
    private ActiveContracts activeContracts;

    public Contracts() {
    }

    public Contracts(String id) {
        this.id = id;
    }

    public Contracts(String id, String codicecontratto) {
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

    public TipoCausa getIdCausa() {
        return idCausa;
    }

    public void setIdCausa(TipoCausa idCausa) {
        this.idCausa = idCausa;
    }

    public TipoContratto getIdTipoContratto() {
        return idTipoContratto;
    }

    public void setIdTipoContratto(TipoContratto idTipoContratto) {
        this.idTipoContratto = idTipoContratto;
    }

    public ActiveContracts getActiveContracts() {
        return activeContracts;
    }

    public void setActiveContracts(ActiveContracts activeContracts) {
        this.activeContracts = activeContracts;
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
        if (!(object instanceof Contracts)) {
            return false;
        }
        Contracts other = (Contracts) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "it.carvin.carvinwebappjpa.Contracts[ id=" + id + " ]";
    }
    
}
