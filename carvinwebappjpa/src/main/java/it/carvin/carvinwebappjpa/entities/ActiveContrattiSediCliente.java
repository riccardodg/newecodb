/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.carvin.carvinwebappjpa.entities;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Riccardo Del Gratta &lt;riccardo.delgratta@ilc.cnr.it&gt;
 */
@Entity
@Table(name = "ACTIVE_CONTRATTI_SEDI_CLIENTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ActiveContrattiSediCliente.findAll", query = "SELECT a FROM ActiveContrattiSediCliente a")
    , @NamedQuery(name = "ActiveContrattiSediCliente.findByIdContratto", query = "SELECT a FROM ActiveContrattiSediCliente a WHERE a.activeContrattiSediClientePK.idContratto = :idContratto")
    , @NamedQuery(name = "ActiveContrattiSediCliente.findByIdSede", query = "SELECT a FROM ActiveContrattiSediCliente a WHERE a.activeContrattiSediClientePK.idSede = :idSede")})
public class ActiveContrattiSediCliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ActiveContrattiSediClientePK activeContrattiSediClientePK;
    @JoinColumn(name = "ID_TIPO_MOD_CONTRATTO", referencedColumnName = "ID")
    @ManyToOne
    private TipoModContratto idTipoModContratto;
    @JoinColumn(name = "ID_CONTRATTO", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ActiveContracts activeContracts;
    @JoinColumn(name = "ID_CLIENTE", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private ActiveClients idCliente;
    @JoinColumn(name = "ID_PARTNER", referencedColumnName = "ID")
    @ManyToOne
    private ActiveClients idPartner;
    @JoinColumn(name = "ID_SEDE", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private SediAttive sediAttive;

    public ActiveContrattiSediCliente() {
    }

    public ActiveContrattiSediCliente(ActiveContrattiSediClientePK activeContrattiSediClientePK) {
        this.activeContrattiSediClientePK = activeContrattiSediClientePK;
    }

    public ActiveContrattiSediCliente(String idContratto, String idSede) {
        this.activeContrattiSediClientePK = new ActiveContrattiSediClientePK(idContratto, idSede);
    }

    public ActiveContrattiSediClientePK getActiveContrattiSediClientePK() {
        return activeContrattiSediClientePK;
    }

    public void setActiveContrattiSediClientePK(ActiveContrattiSediClientePK activeContrattiSediClientePK) {
        this.activeContrattiSediClientePK = activeContrattiSediClientePK;
    }

    public TipoModContratto getIdTipoModContratto() {
        return idTipoModContratto;
    }

    public void setIdTipoModContratto(TipoModContratto idTipoModContratto) {
        this.idTipoModContratto = idTipoModContratto;
    }

    public ActiveContracts getActiveContracts() {
        return activeContracts;
    }

    public void setActiveContracts(ActiveContracts activeContracts) {
        this.activeContracts = activeContracts;
    }

    public ActiveClients getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(ActiveClients idCliente) {
        this.idCliente = idCliente;
    }

    public ActiveClients getIdPartner() {
        return idPartner;
    }

    public void setIdPartner(ActiveClients idPartner) {
        this.idPartner = idPartner;
    }

    public SediAttive getSediAttive() {
        return sediAttive;
    }

    public void setSediAttive(SediAttive sediAttive) {
        this.sediAttive = sediAttive;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (activeContrattiSediClientePK != null ? activeContrattiSediClientePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ActiveContrattiSediCliente)) {
            return false;
        }
        ActiveContrattiSediCliente other = (ActiveContrattiSediCliente) object;
        if ((this.activeContrattiSediClientePK == null && other.activeContrattiSediClientePK != null) || (this.activeContrattiSediClientePK != null && !this.activeContrattiSediClientePK.equals(other.activeContrattiSediClientePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "it.carvin.carvinwebappjpa.ActiveContrattiSediCliente[ activeContrattiSediClientePK=" + activeContrattiSediClientePK + " ]";
    }
    
}
