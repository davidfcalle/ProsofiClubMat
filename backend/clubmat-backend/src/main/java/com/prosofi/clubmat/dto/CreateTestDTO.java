package com.prosofi.clubmat.dto;

import java.util.Date;

public class CreateTestDTO {
	
	private Date fecha;
	
	private Integer numpreguntas;
	
	private Integer grado;
	
	private String dificultad;
	
	private String tema;
	
	private boolean prueba;
	
	private Integer idOlimpiada;
	
	
	
	public CreateTestDTO(){}
	
	
	
	public boolean getPrueba() {
		return prueba;
	}



	public void setPrueba(boolean prueba) {
		this.prueba = prueba;
	}



	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Integer getNumpreguntas() {
		return numpreguntas;
	}

	public void setNumpreguntas(Integer numpreguntas) {
		this.numpreguntas = numpreguntas;
	}

	public Integer getGrado() {
		return grado;
	}

	public void setGrado(Integer grado) {
		this.grado = grado;
	}

	public String getDificultad() {
		return dificultad;
	}

	public void setDificutad(String dificutad) {
		this.dificultad = dificutad;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}



	public Integer getIdOlimpiada() {
		return idOlimpiada;
	}



	public void setIdOlimpiada(Integer idOlimpiada) {
		this.idOlimpiada = idOlimpiada;
	}
	
	
	
}
