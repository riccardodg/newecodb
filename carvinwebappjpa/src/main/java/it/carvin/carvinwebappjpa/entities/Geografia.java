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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "GEOGRAFIA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Geografia.findAll", query = "SELECT g FROM Geografia g")
    , @NamedQuery(name = "Geografia.findById", query = "SELECT g FROM Geografia g WHERE g.id = :id")
    , @NamedQuery(name = "Geografia.findByCodicegeografia", query = "SELECT g FROM Geografia g WHERE g.codicegeografia = :codicegeografia")
    , @NamedQuery(name = "Geografia.findByProvincia", query = "SELECT g FROM Geografia g WHERE g.provincia = :provincia")
    , @NamedQuery(name = "Geografia.findByMicrozona", query = "SELECT g FROM Geografia g WHERE g.microzona = :microzona")
    , @NamedQuery(name = "Geografia.findByMacrozona", query = "SELECT g FROM Geografia g WHERE g.macrozona = :macrozona")})
public class Geografia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ID")
    private String id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "CODICEGEOGRAFIA")
    private String codicegeografia;
    @Size(max = 2)
    @Column(name = "PROVINCIA")
    private String provincia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "MICROZONA")
    private String microzona;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "MACROZONA")
    private String macrozona;
    @JoinTable(name = "ACTIVE_SEDI_GEOGRAFIA", joinColumns = {
        @JoinColumn(name = "ID_GEOGRAFIA", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "ID_SEDE", referencedColumnName = "ID")})
    @ManyToMany
    private Collection<SediAttive> sediAttiveCollection;

    public Geografia() {
    }

    public Geografia(String id) {
        this.id = id;
    }

    public Geografia(String id, String codicegeografia, String microzona, String macrozona) {
        this.id = id;
        this.codicegeografia = codicegeografia;
        this.microzona = microzona;
        this.macrozona = macrozona;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCodicegeografia() {
        return codicegeografia;
    }

    public void setCodicegeografia(String codicegeografia) {
        this.codicegeografia = codicegeografia;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getMicrozona() {
        return microzona;
    }

    public void setMicrozona(String microzona) {
        this.microzona = microzona;
    }

    public String getMacrozona() {
        return macrozona;
    }

    public void setMacrozona(String macrozona) {
        this.macrozona = macrozona;
    }

    @XmlTransient
    public Collection<SediAttive> getSediAttiveCollection() {
        return sediAttiveCollection;
    }

    public void setSediAttiveCollection(Collection<SediAttive> sediAttiveCollection) {
        this.sediAttiveCollection = sediAttiveCollection;
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
        if (!(object instanceof Geografia)) {
            return false;
        }
        Geografia other = (Geografia) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "it.carvin.carvinwebappjpa.Geografia[ id=" + id + " ]";
    }
    
}
