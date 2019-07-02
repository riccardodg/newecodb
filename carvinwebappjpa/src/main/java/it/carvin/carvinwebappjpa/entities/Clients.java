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
@Table(name = "CLIENTS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clients.findAll", query = "SELECT c FROM Clients c")
    , @NamedQuery(name = "Clients.findById", query = "SELECT c FROM Clients c WHERE c.id = :id")
    , @NamedQuery(name = "Clients.findByCodicecliente", query = "SELECT c FROM Clients c WHERE c.codicecliente = :codicecliente")
    , @NamedQuery(name = "Clients.findByPaiv", query = "SELECT c FROM Clients c WHERE c.paiv = :paiv")
    , @NamedQuery(name = "Clients.findByRagionesoc", query = "SELECT c FROM Clients c WHERE c.ragionesoc = :ragionesoc")
    , @NamedQuery(name = "Clients.findByCofi", query = "SELECT c FROM Clients c WHERE c.cofi = :cofi")
    , @NamedQuery(name = "Clients.findByDataIni", query = "SELECT c FROM Clients c WHERE c.dataIni = :dataIni")
    , @NamedQuery(name = "Clients.findByDataFin", query = "SELECT c FROM Clients c WHERE c.dataFin = :dataFin")})
public class Clients implements Serializable {

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
    @Size(max = 11)
    @Column(name = "PAIV")
    private String paiv;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "RAGIONESOC")
    private String ragionesoc;
    @Size(max = 16)
    @Column(name = "COFI")
    private String cofi;
    @Column(name = "DATA_INI")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataIni;
    @Column(name = "DATA_FIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataFin;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "clients")
    private ActiveClients activeClients;
    @JoinColumn(name = "ID_CAUSA", referencedColumnName = "ID")
    @ManyToOne
    private TipoCausa idCausa;
    @JoinColumn(name = "ID_TIPO_CLIENTE", referencedColumnName = "ID")
    @ManyToOne
    private TipoCliente idTipoCliente;

    public Clients() {
    }

    public Clients(String id) {
        this.id = id;
    }

    public Clients(String id, String codicecliente, String ragionesoc) {
        this.id = id;
        this.codicecliente = codicecliente;
        this.ragionesoc = ragionesoc;
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

    public String getPaiv() {
        return paiv;
    }

    public void setPaiv(String paiv) {
        this.paiv = paiv;
    }

    public String getRagionesoc() {
        return ragionesoc;
    }

    public void setRagionesoc(String ragionesoc) {
        this.ragionesoc = ragionesoc;
    }

    public String getCofi() {
        return cofi;
    }

    public void setCofi(String cofi) {
        this.cofi = cofi;
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

    public ActiveClients getActiveClients() {
        return activeClients;
    }

    public void setActiveClients(ActiveClients activeClients) {
        this.activeClients = activeClients;
    }

    public TipoCausa getIdCausa() {
        return idCausa;
    }

    public void setIdCausa(TipoCausa idCausa) {
        this.idCausa = idCausa;
    }

    public TipoCliente getIdTipoCliente() {
        return idTipoCliente;
    }

    public void setIdTipoCliente(TipoCliente idTipoCliente) {
        this.idTipoCliente = idTipoCliente;
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
        if (!(object instanceof Clients)) {
            return false;
        }
        Clients other = (Clients) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "it.carvin.carvinwebappjpa.Clients[ id=" + id + " ]";
    }
    
}
