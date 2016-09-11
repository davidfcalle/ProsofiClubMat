package com.prosofi.clubmat.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "prueba")
@XmlRootElement
public class Prueba implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idprueba")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idprueba;
	
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    
    @Size(max = 70)
    @Column(name = "tema")
    private String tema;
    
    @Column(name = "numpreguntas")
    private Integer numpreguntas;
    
    @Column(name = "numcorrectas")
    private Integer numcorrectas;
    
    @Size(max = 30)
    @Column(name = "tipoprueba")
    private String tipoprueba;
    
    @ManyToMany(mappedBy = "pruebaList")
    private List<Pregunta> preguntaList; 
    
    @JoinColumn(name = "idusuario", referencedColumnName = "idusuario")
    @ManyToOne
    private Usuario idusuario;
    
    @OneToMany(mappedBy = "idprueba")
    private List<Olimpiada> olimpiadaList;

    public Prueba() {
    }

    public Prueba(Integer idprueba) {
        this.idprueba = idprueba;
    }

    public Integer getIdprueba() {
        return idprueba;
    }

    public void setIdprueba(Integer idprueba) {
        this.idprueba = idprueba;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public Integer getNumpreguntas() {
        return numpreguntas;
    }

    public void setNumpreguntas(Integer numpreguntas) {
        this.numpreguntas = numpreguntas;
    }

    public Integer getNumcorrectas() {
        return numcorrectas;
    }

    public void setNumcorrectas(Integer numcorrectas) {
        this.numcorrectas = numcorrectas;
    }

    public List<Olimpiada> getOlimpiadaList() {
        return olimpiadaList;
    }

    public void setOlimpiadaList(List<Olimpiada> olimpiadaList) {
        this.olimpiadaList = olimpiadaList;
    }
        

    public String getTipoprueba() {
        return tipoprueba;
    }

    public void setTipoprueba(String tipoprueba) {
        this.tipoprueba = tipoprueba;
    }    
    
    public List<Pregunta> getPreguntaList() {
        return preguntaList;
    }

    public void setPreguntaList(List<Pregunta> preguntaList) {
        this.preguntaList = preguntaList;
    }

    public Usuario getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Usuario idusuario) {
        this.idusuario = idusuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idprueba != null ? idprueba.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prueba)) {
            return false;
        }
        Prueba other = (Prueba) object;
        if ((this.idprueba == null && other.idprueba != null) || (this.idprueba != null && !this.idprueba.equals(other.idprueba))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.javeriana.clubmat.entidades.Prueba[ idprueba=" + idprueba + " ]";
    }
}
