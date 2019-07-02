/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.carvin.carvinwebappjpa.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "TIPO_MANSIONE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoMansione.findAll", query = "SELECT t FROM TipoMansione t")
    , @NamedQuery(name = "TipoMansione.findById", query = "SELECT t FROM TipoMansione t WHERE t.id = :id")
    , @NamedQuery(name = "TipoMansione.findByTipoMansione", query = "SELECT t FROM TipoMansione t WHERE t.tipoMansione = :tipoMansione")})
public class TipoMansione implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "TIPO_MANSIONE")
    private String tipoMansione;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoMansione")
    private Collection<MansionarioContatto> mansionarioContattoCollection;

    public TipoMansione() {
    }

    public TipoMansione(Integer id) {
        this.id = id;
    }

    public TipoMansione(Integer id, String tipoMansione) {
        this.id = id;
        this.tipoMansione = tipoMansione;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipoMansione() {
        return tipoMansione;
    }

    public void setTipoMansione(String tipoMansione) {
        this.tipoMansione = tipoMansione;
    }

    @XmlTransient
    public Collection<MansionarioContatto> getMansionarioContattoCollection() {
        return mansionarioContattoCollection;
    }

    public void setMansionarioContattoCollection(Collection<MansionarioContatto> mansionarioContattoCollection) {
        this.mansionarioContattoCollection = mansionarioContattoCollection;
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
        if (!(object instanceof TipoMansione)) {
            return false;
        }
        TipoMansione other = (TipoMansione) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "it.carvin.carvinwebappjpa.TipoMansione[ id=" + id + " ]";
    }
    
}
