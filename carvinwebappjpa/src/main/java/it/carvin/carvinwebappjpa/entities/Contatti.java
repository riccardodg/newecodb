/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.carvin.carvinwebappjpa.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Riccardo Del Gratta &lt;riccardo.delgratta@ilc.cnr.it&gt;
 */
@Entity
@Table(name = "CONTATTI")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contatti.findAll", query = "SELECT c FROM Contatti c")
    , @NamedQuery(name = "Contatti.findById", query = "SELECT c FROM Contatti c WHERE c.id = :id")
    , @NamedQuery(name = "Contatti.findByCodicecontatto", query = "SELECT c FROM Contatti c WHERE c.codicecontatto = :codicecontatto")
    , @NamedQuery(name = "Contatti.findBySal", query = "SELECT c FROM Contatti c WHERE c.sal = :sal")
    , @NamedQuery(name = "Contatti.findByDataIni", query = "SELECT c FROM Contatti c WHERE c.dataIni = :dataIni")
    , @NamedQuery(name = "Contatti.findByDataFin", query = "SELECT c FROM Contatti c WHERE c.dataFin = :dataFin")})
public class Contatti implements Serializable {

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
    @Column(name = "CODICECONTATTO")
    private String codicecontatto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "SAL")
    private String sal;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "NOME")
    private String nome;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "COGNOME")
    private String cognome;
    @Column(name = "DATA_INI")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataIni;
    @Column(name = "DATA_FIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataFin;
    @JoinColumn(name = "ID_CAUSA", referencedColumnName = "ID")
    @ManyToOne
    private TipoCausa idCausa;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "contatti")
    private ContattiAttivi contattiAttivi;

    public Contatti() {
    }

    public Contatti(String id) {
        this.id = id;
    }

    public Contatti(String id, String codicecontatto, String sal, String nome, String cognome) {
        this.id = id;
        this.codicecontatto = codicecontatto;
        this.sal = sal;
        this.nome = nome;
        this.cognome = cognome;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCodicecontatto() {
        return codicecontatto;
    }

    public void setCodicecontatto(String codicecontatto) {
        this.codicecontatto = codicecontatto;
    }

    public String getSal() {
        return sal;
    }

    public void setSal(String sal) {
        this.sal = sal;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public Date getDataIni() {
        return dataIni;
    }

    public void setDataIni(Date dataIni) {
        this.dataIni = dataIni;
    }

    public Date getDataFin() {
        return dataFin;
    }

    public void setDataFin(Date dataFin) {
        this.dataFin = dataFin;
    }

    public TipoCausa getIdCausa() {
        return idCausa;
    }

    public void setIdCausa(TipoCausa idCausa) {
        this.idCausa = idCausa;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contatti)) {
            return false;
        }
        Contatti other = (Contatti) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "it.carvin.carvinwebappjpa.Contatti[ id=" + id + " ]";
    }
    
}
