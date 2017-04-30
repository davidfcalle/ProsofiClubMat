package com.prosofi.clubmat.dto;

import java.io.Serializable;

public class ResultsDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private String nombreEstudiante;
	private String apellidoEstudiante;
	private Integer numCorrectas;
	private String institucion;
	private String club;
	
	public String getNombreEstudiante() {
		return nombreEstudiante;
	}
	
	public void setNombreEstudiante(String nombreEstudiante) {
		this.nombreEstudiante = nombreEstudiante;
	}
	
	public String getApellidoEstudiante() {
		return apellidoEstudiante;
	}

	public void setApellidoEstudiante(String apellidoEstudiante) {
		this.apellidoEstudiante = apellidoEstudiante;
	}

	public Integer getNumCorrectas() {
		return numCorrectas;
	}
	
	public void setNumCorrectas(Integer numCorrectas) {
		this.numCorrectas = numCorrectas;
	}
	
	public String getInstitucion() {
		return institucion;
	}
	
	public void setInstitucion(String institucion) {
		this.institucion = institucion;
	}
	
	public String getClub() {
		return club;
	}
	
	public void setClub(String club) {
		this.club = club;
	}
}
