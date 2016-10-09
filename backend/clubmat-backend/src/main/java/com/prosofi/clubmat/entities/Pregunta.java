package com.prosofi.clubmat.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "pregunta")
@XmlRootElement
public class Pregunta implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @Basic(optional = false)
    @Column(name = "idpregunta")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idpregunta;
	
    @Size(max = 30)
    @Column(name = "clasificacion")
    private String clasificacion;
    
    @Size(max = 15)
    @Column(name = "nivelacademico")
    private String nivelacademico;
    
    @Size(max = 50)
    @Column(name = "tematica")
    private String tematica;
    
    @Size(max = 20)
    @Column(name = "dificultad")
    private String dificultad;
    
    @Size(max = 100)
    @Column(name = "titulo")
    private String titulo;
    
    @Size(max = 700)
    @Column(name = "enunciado")
    private String enunciado;
    
    @Column(name = "aprobado")
    private String aprobado;

    
    @Column(name = "resultado")
    private String resultado;
    
    @JsonIgnore
    @JoinTable(name = "prueba_pregunta", joinColumns = {
        @JoinColumn(name = "pregunta_idpregunta", referencedColumnName = "idpregunta")}, inverseJoinColumns = {
        @JoinColumn(name = "prueba_idprueba", referencedColumnName = "idprueba")})
    @ManyToMany
    private List<Prueba> pruebaList;
    
    
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idpregunta")
    private List<Opcionpregunta> opcionpreguntaList;

    public Pregunta() {
    }

    public Pregunta(Integer idpregunta) {
        this.idpregunta = idpregunta;
    }

    public Integer getIdpregunta() {
        return idpregunta;
    }

    public void setIdpregunta(Integer idpregunta) {
        this.idpregunta = idpregunta;
    }
    
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAprobado() {
        return aprobado;
    }

    public void setAprobado(String aprobado) {
        this.aprobado = aprobado;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public String getNivelacademico() {
        return nivelacademico;
    }

    public void setNivelacademico(String nivelacademico) {
        this.nivelacademico = nivelacademico;
    }

    public String getTematica() {
        return tematica;
    }

    public void setTematica(String tematica) {
        this.tematica = tematica;
    }

    public String getDificultad() {
        return dificultad;
    }

    public void setDificultad(String dificultad) {
        this.dificultad = dificultad;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }    
        
    
    public List<Prueba> getPruebaList() {
        return pruebaList;
    }

    public void setPruebaList(List<Prueba> pruebaList) {
        this.pruebaList = pruebaList;
    }
    
    
    
    public List<Opcionpregunta> getOpcionpreguntaList() {
        return opcionpreguntaList;
    }

    @JsonProperty
    public void setOpcionpreguntaList(List<Opcionpregunta> opcionpreguntaList) {
        this.opcionpreguntaList = opcionpreguntaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpregunta != null ? idpregunta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pregunta)) {
            return false;
        }
        Pregunta other = (Pregunta) object;
        if ((this.idpregunta == null && other.idpregunta != null) || (this.idpregunta != null && !this.idpregunta.equals(other.idpregunta))) {
            return false;
        }
        return true;
    }

	@Override
	public String toString() {
		return "Pregunta [idpregunta=" + idpregunta + ", clasificacion=" + clasificacion + ", nivelacademico="
				+ nivelacademico + ", tematica=" + tematica + ", dificultad=" + dificultad + ", titulo=" + titulo
				+ ", enunciado=" + enunciado + ", aprobado=" + aprobado + ", resultado=" + resultado + " opciones="+ opcionpreguntaList + "]";
	}

    
}
