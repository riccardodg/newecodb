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
public class ActiveContrattiSediClientePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ID_CONTRATTO")
    private String idContratto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ID_SEDE")
    private String idSede;

    public ActiveContrattiSediClientePK() {
    }

    public ActiveContrattiSediClientePK(String idContratto, String idSede) {
        this.idContratto = idContratto;
        this.idSede = idSede;
    }

    public String getIdContratto() {
        return idContratto;
    }

    public void setIdContratto(String idContratto) {
        this.idContratto = idContratto;
    }

    public String getIdSede() {
        return idSede;
    }

    public void setIdSede(String idSede) {
        this.idSede = idSede;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idContratto != null ? idContratto.hashCode() : 0);
        hash += (idSede != null ? idSede.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ActiveContrattiSediClientePK)) {
            return false;
        }
        ActiveContrattiSediClientePK other = (ActiveContrattiSediClientePK) object;
        if ((this.idContratto == null && other.idContratto != null) || (this.idContratto != null && !this.idContratto.equals(other.idContratto))) {
            return false;
        }
        if ((this.idSede == null && other.idSede != null) || (this.idSede != null && !this.idSede.equals(other.idSede))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "it.carvin.carvinwebappjpa.ActiveContrattiSediClientePK[ idContratto=" + idContratto + ", idSede=" + idSede + " ]";
    }
    
}
