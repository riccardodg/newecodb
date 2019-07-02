/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.carvin.carvinwebappjpa.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Riccardo Del Gratta &lt;riccardo.delgratta@ilc.cnr.it&gt;
 */
@Entity
@Table(name = "TIPO_SEDE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoSede.findAll", query = "SELECT t FROM TipoSede t")
    , @NamedQuery(name = "TipoSede.findById", query = "SELECT t FROM TipoSede t WHERE t.id = :id")
    , @NamedQuery(name = "TipoSede.findByTipoSede", query = "SELECT t FROM TipoSede t WHERE t.tipoSede = :tipoSede")})
public class TipoSede implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "TIPO_SEDE")
    private String tipoSede;
    @OneToMany(mappedBy = "idTipoSede")
    private Collection<SediAttive> sediAttiveCollection;
    @OneToMany(mappedBy = "idTipoSede")
    private Collection<Sedi> sediCollection;

    public TipoSede() {
    }

    public TipoSede(Integer id) {
        this.id = id;
    }

    public TipoSede(Integer id, String tipoSede) {
        this.id = id;
        this.tipoSede = tipoSede;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipoSede() {
        return tipoSede;
    }

    public void setTipoSede(String tipoSede) {
        this.tipoSede = tipoSede;
    }

    @XmlTransient
    public Collection<SediAttive> getSediAttiveCollection() {
        return sediAttiveCollection;
    }

    public void setSediAttiveCollection(Collection<SediAttive> sediAttiveCollection) {
        this.sediAttiveCollection = sediAttiveCollection;
    }

    @XmlTransient
    public Collection<Sedi> getSediCollection() {
        return sediCollection;
    }

    public void setSediCollection(Collection<Sedi> sediCollection) {
        this.sediCollection = sediCollection;
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
        if (!(object instanceof TipoSede)) {
            return false;
        }
        TipoSede other = (TipoSede) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "it.carvin.carvinwebappjpa.TipoSede[ id=" + id + " ]";
    }
    
}
