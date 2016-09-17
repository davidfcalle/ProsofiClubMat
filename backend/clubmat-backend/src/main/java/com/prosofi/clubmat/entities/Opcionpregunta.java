package com.prosofi.clubmat.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "opcionpregunta")
@XmlRootElement
public class Opcionpregunta implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @NotNull
    @Column(name = "idopcionpregunta")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idopcionpregunta;    

    public Integer getIdopcionpregunta() {
        return idopcionpregunta;
    }

    public void setIdopcionpregunta(Integer idopcionpregunta) {
        this.idopcionpregunta = idopcionpregunta;
    }
    
    @Size(max = 500)
    @Column(name = "opcion")
    private String opcion;
    
    @Column(name = "correcta")
    private Boolean correcta;
    
    
    @JsonIgnore
    @JoinColumn(name = "idpregunta", referencedColumnName = "idpregunta")
    @ManyToOne
    private Pregunta idpregunta;

    public Opcionpregunta() {
    }

    public String getOpcion() {
        return opcion;
    }

    public void setOpcion(String opcion) {
        this.opcion = opcion;
    }

    public Boolean getCorrecta() {
        return correcta;
    }

    public void setCorrecta(Boolean correcta) {
        this.correcta = correcta;
    }

    public Pregunta getIdpregunta() {
        return idpregunta;
    }

    public void setIdpregunta(Pregunta idpregunta) {
        this.idpregunta = idpregunta;
    }
}
