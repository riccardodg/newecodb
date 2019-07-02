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
@Table(name = "HIS_CONTATTI")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HisContatti.findAll", query = "SELECT h FROM HisContatti h")
    , @NamedQuery(name = "HisContatti.findById", query = "SELECT h FROM HisContatti h WHERE h.id = :id")
    , @NamedQuery(name = "HisContatti.findByIdContattoB", query = "SELECT h FROM HisContatti h WHERE h.idContattoB = :idContattoB")})
public class HisContatti implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ID_CONTATTO_B")
    private String idContattoB;
    @JoinColumn(name = "ID_CONTATTO_A", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private ContattiAttivi idContattoA;

    public HisContatti() {
    }

    public HisContatti(Integer id) {
        this.id = id;
    }

    public HisContatti(Integer id, String idContattoB) {
        this.id = id;
        this.idContattoB = idContattoB;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdContattoB() {
        return idContattoB;
    }

    public void setIdContattoB(String idContattoB) {
        this.idContattoB = idContattoB;
    }

    public ContattiAttivi getIdContattoA() {
        return idContattoA;
    }

    public void setIdContattoA(ContattiAttivi idContattoA) {
        this.idContattoA = idContattoA;
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
        if (!(object instanceof HisContatti)) {
            return false;
        }
        HisContatti other = (HisContatti) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "it.carvin.carvinwebappjpa.HisContatti[ id=" + id + " ]";
    }
    
}
