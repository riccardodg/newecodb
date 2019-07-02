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
@Table(name = "TIPO_CONTATTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoContatto.findAll", query = "SELECT t FROM TipoContatto t")
    , @NamedQuery(name = "TipoContatto.findById", query = "SELECT t FROM TipoContatto t WHERE t.id = :id")
    , @NamedQuery(name = "TipoContatto.findByTipoContatto", query = "SELECT t FROM TipoContatto t WHERE t.tipoContatto = :tipoContatto")})
public class TipoContatto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "TIPO_CONTATTO")
    private String tipoContatto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoContatto")
    private Collection<ValoreTipoContatto> valoreTipoContattoCollection;

    public TipoContatto() {
    }

    public TipoContatto(Integer id) {
        this.id = id;
    }

    public TipoContatto(Integer id, String tipoContatto) {
        this.id = id;
        this.tipoContatto = tipoContatto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipoContatto() {
        return tipoContatto;
    }

    public void setTipoContatto(String tipoContatto) {
        this.tipoContatto = tipoContatto;
    }

    @XmlTransient
    public Collection<ValoreTipoContatto> getValoreTipoContattoCollection() {
        return valoreTipoContattoCollection;
    }

    public void setValoreTipoContattoCollection(Collection<ValoreTipoContatto> valoreTipoContattoCollection) {
        this.valoreTipoContattoCollection = valoreTipoContattoCollection;
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
        if (!(object instanceof TipoContatto)) {
            return false;
        }
        TipoContatto other = (TipoContatto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "it.carvin.carvinwebappjpa.TipoContatto[ id=" + id + " ]";
    }
    
}
