/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.carvin.carvinwebappjpa.entities;

import java.io.Serializable;
import javax.persistence.Column;
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
@Table(name = "MANSIONARIO_CONTATTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MansionarioContatto.findAll", query = "SELECT m FROM MansionarioContatto m")
    , @NamedQuery(name = "MansionarioContatto.findByIdContatto", query = "SELECT m FROM MansionarioContatto m WHERE m.mansionarioContattoPK.idContatto = :idContatto")
    , @NamedQuery(name = "MansionarioContatto.findByIdTipoMansione", query = "SELECT m FROM MansionarioContatto m WHERE m.mansionarioContattoPK.idTipoMansione = :idTipoMansione")
    , @NamedQuery(name = "MansionarioContatto.findByPrincipale", query = "SELECT m FROM MansionarioContatto m WHERE m.principale = :principale")})
public class MansionarioContatto implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MansionarioContattoPK mansionarioContattoPK;
    @Column(name = "PRINCIPALE")
    private Boolean principale;
    @JoinColumn(name = "ID_TIPO_MANSIONE", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TipoMansione tipoMansione;
    @JoinColumn(name = "ID_CONTATTO", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ContattiAttivi contattiAttivi;

    public MansionarioContatto() {
    }

    public MansionarioContatto(MansionarioContattoPK mansionarioContattoPK) {
        this.mansionarioContattoPK = mansionarioContattoPK;
    }

    public MansionarioContatto(String idContatto, int idTipoMansione) {
        this.mansionarioContattoPK = new MansionarioContattoPK(idContatto, idTipoMansione);
    }

    public MansionarioContattoPK getMansionarioContattoPK() {
        return mansionarioContattoPK;
    }

    public void setMansionarioContattoPK(MansionarioContattoPK mansionarioContattoPK) {
        this.mansionarioContattoPK = mansionarioContattoPK;
    }

    public Boolean getPrincipale() {
        return principale;
    }

    public void setPrincipale(Boolean principale) {
        this.principale = principale;
    }

    public TipoMansione getTipoMansione() {
        return tipoMansione;
    }

    public void setTipoMansione(TipoMansione tipoMansione) {
        this.tipoMansione = tipoMansione;
    }

    public ContattiAttivi getContattiAttivi() {
        return contattiAttivi;
    }

    public void setContattiAttivi(ContattiAttivi contattiAttivi) {
        this.contattiAttivi = contattiAttivi;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mansionarioContattoPK != null ? mansionarioContattoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MansionarioContatto)) {
            return false;
        }
        MansionarioContatto other = (MansionarioContatto) object;
        if ((this.mansionarioContattoPK == null && other.mansionarioContattoPK != null) || (this.mansionarioContattoPK != null && !this.mansionarioContattoPK.equals(other.mansionarioContattoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "it.carvin.carvinwebappjpa.MansionarioContatto[ mansionarioContattoPK=" + mansionarioContattoPK + " ]";
    }
    
}
