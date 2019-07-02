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
@Table(name = "SEDI")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sedi.findAll", query = "SELECT s FROM Sedi s")
    , @NamedQuery(name = "Sedi.findById", query = "SELECT s FROM Sedi s WHERE s.id = :id")
    , @NamedQuery(name = "Sedi.findByCodicesede", query = "SELECT s FROM Sedi s WHERE s.codicesede = :codicesede")
    , @NamedQuery(name = "Sedi.findByDataIni", query = "SELECT s FROM Sedi s WHERE s.dataIni = :dataIni")
    , @NamedQuery(name = "Sedi.findByDataFin", query = "SELECT s FROM Sedi s WHERE s.dataFin = :dataFin")})
public class Sedi implements Serializable {

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
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "sedi")
    private SediAttive sediAttive;
    @JoinColumn(name = "ID_CAUSA", referencedColumnName = "ID")
    @ManyToOne
    private TipoCausa idCausa;
    @JoinColumn(name = "ID_TIPO_SEDE", referencedColumnName = "ID")
    @ManyToOne
    private TipoSede idTipoSede;

    public Sedi() {
    }

    public Sedi(String id) {
        this.id = id;
    }

    public Sedi(String id, String codicesede) {
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

    public SediAttive getSediAttive() {
        return sediAttive;
    }

    public void setSediAttive(SediAttive sediAttive) {
        this.sediAttive = sediAttive;
    }

    public TipoCausa getIdCausa() {
        return idCausa;
    }

    public void setIdCausa(TipoCausa idCausa) {
        this.idCausa = idCausa;
    }

    public TipoSede getIdTipoSede() {
        return idTipoSede;
    }

    public void setIdTipoSede(TipoSede idTipoSede) {
        this.idTipoSede = idTipoSede;
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
        if (!(object instanceof Sedi)) {
            return false;
        }
        Sedi other = (Sedi) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "it.carvin.carvinwebappjpa.Sedi[ id=" + id + " ]";
    }
    
}
