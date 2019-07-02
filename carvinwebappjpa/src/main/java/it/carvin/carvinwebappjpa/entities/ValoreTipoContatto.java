/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.carvin.carvinwebappjpa.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "VALORE_TIPO_CONTATTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ValoreTipoContatto.findAll", query = "SELECT v FROM ValoreTipoContatto v")
    , @NamedQuery(name = "ValoreTipoContatto.findByIdContatto", query = "SELECT v FROM ValoreTipoContatto v WHERE v.valoreTipoContattoPK.idContatto = :idContatto")
    , @NamedQuery(name = "ValoreTipoContatto.findByIdTipoContatto", query = "SELECT v FROM ValoreTipoContatto v WHERE v.valoreTipoContattoPK.idTipoContatto = :idTipoContatto")
    , @NamedQuery(name = "ValoreTipoContatto.findByValoreContatto", query = "SELECT v FROM ValoreTipoContatto v WHERE v.valoreContatto = :valoreContatto")
    , @NamedQuery(name = "ValoreTipoContatto.findByPrincipale", query = "SELECT v FROM ValoreTipoContatto v WHERE v.principale = :principale")})
public class ValoreTipoContatto implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ValoreTipoContattoPK valoreTipoContattoPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "VALORE_CONTATTO")
    private String valoreContatto;
    @Column(name = "PRINCIPALE")
    private Boolean principale;
    @JoinColumn(name = "ID_TIPO_CONTATTO", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TipoContatto tipoContatto;
    @JoinColumn(name = "ID_CONTATTO", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ContattiAttivi contattiAttivi;

    public ValoreTipoContatto() {
    }

    public ValoreTipoContatto(ValoreTipoContattoPK valoreTipoContattoPK) {
        this.valoreTipoContattoPK = valoreTipoContattoPK;
    }

    public ValoreTipoContatto(ValoreTipoContattoPK valoreTipoContattoPK, String valoreContatto) {
        this.valoreTipoContattoPK = valoreTipoContattoPK;
        this.valoreContatto = valoreContatto;
    }

    public ValoreTipoContatto(String idContatto, int idTipoContatto) {
        this.valoreTipoContattoPK = new ValoreTipoContattoPK(idContatto, idTipoContatto);
    }

    public ValoreTipoContattoPK getValoreTipoContattoPK() {
        return valoreTipoContattoPK;
    }

    public void setValoreTipoContattoPK(ValoreTipoContattoPK valoreTipoContattoPK) {
        this.valoreTipoContattoPK = valoreTipoContattoPK;
    }

    public String getValoreContatto() {
        return valoreContatto;
    }

    public void setValoreContatto(String valoreContatto) {
        this.valoreContatto = valoreContatto;
    }

    public Boolean getPrincipale() {
        return principale;
    }

    public void setPrincipale(Boolean principale) {
        this.principale = principale;
    }

    public TipoContatto getTipoContatto() {
        return tipoContatto;
    }

    public void setTipoContatto(TipoContatto tipoContatto) {
        this.tipoContatto = tipoContatto;
    }

    public ContattiAttivi getContattiAttivi() {
        return contattiAttivi;
    }

    public void setContattiAttivi(ContattiAttivi contattiAttivi) {
        this.contattiAttivi = contattiAttivi;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (valoreTipoContattoPK != null ? valoreTipoContattoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ValoreTipoContatto)) {
            return false;
        }
        ValoreTipoContatto other = (ValoreTipoContatto) object;
        if ((this.valoreTipoContattoPK == null && other.valoreTipoContattoPK != null) || (this.valoreTipoContattoPK != null && !this.valoreTipoContattoPK.equals(other.valoreTipoContattoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "it.carvin.carvinwebappjpa.ValoreTipoContatto[ valoreTipoContattoPK=" + valoreTipoContattoPK + " ]";
    }
    
}
