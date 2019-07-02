/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.carvin.carvinwebappjpa.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Riccardo Del Gratta &lt;riccardo.delgratta@ilc.cnr.it&gt;
 */
@Entity
@Table(name = "HIS_CONTRACTS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HisContracts.findAll", query = "SELECT h FROM HisContracts h")
    , @NamedQuery(name = "HisContracts.findById", query = "SELECT h FROM HisContracts h WHERE h.id = :id")
    , @NamedQuery(name = "HisContracts.findByIdContrattoB", query = "SELECT h FROM HisContracts h WHERE h.idContrattoB = :idContrattoB")})
public class HisContracts implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ID_CONTRATTO_B")
    private String idContrattoB;
    @JoinColumn(name = "ID_CONTRATTO_A", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private ActiveContracts idContrattoA;

    public HisContracts() {
    }

    public HisContracts(Integer id) {
        this.id = id;
    }

    public HisContracts(Integer id, String idContrattoB) {
        this.id = id;
        this.idContrattoB = idContrattoB;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdContrattoB() {
        return idContrattoB;
    }

    public void setIdContrattoB(String idContrattoB) {
        this.idContrattoB = idContrattoB;
    }

    public ActiveContracts getIdContrattoA() {
        return idContrattoA;
    }

    public void setIdContrattoA(ActiveContracts idContrattoA) {
        this.idContrattoA = idContrattoA;
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
        if (!(object instanceof HisContracts)) {
            return false;
        }
        HisContracts other = (HisContracts) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "it.carvin.carvinwebappjpa.HisContracts[ id=" + id + " ]";
    }
    
}
