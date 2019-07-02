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
@Table(name = "HIS_SEDI")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HisSedi.findAll", query = "SELECT h FROM HisSedi h")
    , @NamedQuery(name = "HisSedi.findById", query = "SELECT h FROM HisSedi h WHERE h.id = :id")
    , @NamedQuery(name = "HisSedi.findByIdSedeB", query = "SELECT h FROM HisSedi h WHERE h.idSedeB = :idSedeB")})
public class HisSedi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ID_SEDE_B")
    private String idSedeB;
    @JoinColumn(name = "ID_SEDE_A", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private SediAttive idSedeA;

    public HisSedi() {
    }

    public HisSedi(Integer id) {
        this.id = id;
    }

    public HisSedi(Integer id, String idSedeB) {
        this.id = id;
        this.idSedeB = idSedeB;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdSedeB() {
        return idSedeB;
    }

    public void setIdSedeB(String idSedeB) {
        this.idSedeB = idSedeB;
    }

    public SediAttive getIdSedeA() {
        return idSedeA;
    }

    public void setIdSedeA(SediAttive idSedeA) {
        this.idSedeA = idSedeA;
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
        if (!(object instanceof HisSedi)) {
            return false;
        }
        HisSedi other = (HisSedi) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "it.carvin.carvinwebappjpa.HisSedi[ id=" + id + " ]";
    }
    
}
