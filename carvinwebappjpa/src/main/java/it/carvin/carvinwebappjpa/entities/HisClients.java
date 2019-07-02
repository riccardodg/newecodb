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
@Table(name = "HIS_CLIENTS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HisClients.findAll", query = "SELECT h FROM HisClients h")
    , @NamedQuery(name = "HisClients.findById", query = "SELECT h FROM HisClients h WHERE h.id = :id")
    , @NamedQuery(name = "HisClients.findByIdClienteB", query = "SELECT h FROM HisClients h WHERE h.idClienteB = :idClienteB")})
public class HisClients implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ID_CLIENTE_B")
    private String idClienteB;
    @JoinColumn(name = "ID_CLIENTE_A", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private ActiveClients idClienteA;

    public HisClients() {
    }

    public HisClients(Integer id) {
        this.id = id;
    }

    public HisClients(Integer id, String idClienteB) {
        this.id = id;
        this.idClienteB = idClienteB;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdClienteB() {
        return idClienteB;
    }

    public void setIdClienteB(String idClienteB) {
        this.idClienteB = idClienteB;
    }

    public ActiveClients getIdClienteA() {
        return idClienteA;
    }

    public void setIdClienteA(ActiveClients idClienteA) {
        this.idClienteA = idClienteA;
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
        if (!(object instanceof HisClients)) {
            return false;
        }
        HisClients other = (HisClients) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "it.carvin.carvinwebappjpa.HisClients[ id=" + id + " ]";
    }
    
}
