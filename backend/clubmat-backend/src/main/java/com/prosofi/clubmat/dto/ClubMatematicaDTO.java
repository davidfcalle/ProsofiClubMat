package com.prosofi.clubmat.dto;

import java.io.Serializable;

public class ClubMatematicaDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer idclub;
	private String nombre;
	private String lema;
	private String institucion;
	
	public Integer getIdclub() {
		return idclub;
	}
	
	public void setIdclub(Integer idclub) {
		this.idclub = idclub;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getLema() {
		return lema;
	}
	
	public void setLema(String lema) {
		this.lema = lema;
	}
	
	public String getInstitucion() {
		return institucion;
	}
	
	public void setInstitucion(String institucion) {
		this.institucion = institucion;
	}

}
