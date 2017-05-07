package com.prosofi.clubmat.entities;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "usuarioprueba")
@XmlRootElement
public class UsuarioPrueba implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
    @Basic(optional = false)
    @Column(name = "idusuarioprueba")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idusuarioprueba;
	
	@JsonIgnore
	@JoinColumn(name = "idusuario", referencedColumnName = "idusuario")
	private Integer idusuario;
	
	@JsonIgnore
	@JoinColumn(name = "idprueba", referencedColumnName = "idprueba")
	private Integer idprueba;
	
	@JsonIgnore
	private Integer numCorrectas;
	
	@JsonIgnore
	private Long time;

	public Integer getIdusuarioprueba() {
		return idusuarioprueba;
	}

	public void setIdusuarioprueba(Integer idusuarioprueba) {
		this.idusuarioprueba = idusuarioprueba;
	}

	public Integer getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(Integer idusuario) {
		this.idusuario = idusuario;
	}

	public Integer getIdprueba() {
		return idprueba;
	}

	public void setIdprueba(Integer idprueba) {
		this.idprueba = idprueba;
	}

	public Integer getNumCorrectas() {
		return numCorrectas;
	}

	public void setNumCorrectas(Integer numCorrectas) {
		this.numCorrectas = numCorrectas;
	}

	public Long getTime() {
		return time;
	}

	public void setTime(Long time) {
		this.time = time;
	}
}
