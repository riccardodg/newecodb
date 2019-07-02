/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.carvin.carvinwebappjpa.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Riccardo Del Gratta &lt;riccardo.delgratta@ilc.cnr.it&gt;
 */
@Embeddable
public class MansionarioContattoPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ID_CONTATTO")
    private String idContatto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TIPO_MANSIONE")
    private int idTipoMansione;

    public MansionarioContattoPK() {
    }

    public MansionarioContattoPK(String idContatto, int idTipoMansione) {
        this.idContatto = idContatto;
        this.idTipoMansione = idTipoMansione;
    }

    public String getIdContatto() {
        return idContatto;
    }

    public void setIdContatto(String idContatto) {
        this.idContatto = idContatto;
    }

    public int getIdTipoMansione() {
        return idTipoMansione;
    }

    public void setIdTipoMansione(int idTipoMansione) {
        this.idTipoMansione = idTipoMansione;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idContatto != null ? idContatto.hashCode() : 0);
        hash += (int) idTipoMansione;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MansionarioContattoPK)) {
            return false;
        }
        MansionarioContattoPK other = (MansionarioContattoPK) object;
        if ((this.idContatto == null && other.idContatto != null) || (this.idContatto != null && !this.idContatto.equals(other.idContatto))) {
            return false;
        }
        if (this.idTipoMansione != other.idTipoMansione) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "it.carvin.carvinwebappjpa.MansionarioContattoPK[ idContatto=" + idContatto + ", idTipoMansione=" + idTipoMansione + " ]";
    }
    
}
