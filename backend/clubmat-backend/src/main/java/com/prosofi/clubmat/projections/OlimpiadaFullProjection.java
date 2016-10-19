package com.prosofi.clubmat.projections;

import java.util.Date;

import org.springframework.data.rest.core.config.Projection;

import com.prosofi.clubmat.entities.Clubmatematicas;
import com.prosofi.clubmat.entities.Olimpiada;
import com.prosofi.clubmat.entities.Prueba;
import com.prosofi.clubmat.entities.Usuario;

@Projection(name="full", types = { Olimpiada.class, Usuario.class, Prueba.class })
public interface OlimpiadaFullProjection {
	
	Integer getIdolimpiada();
	String getNombre();
	String getCiudad();
	String getLugar();
	String getHora();
	String getDireccion();
	String getActivacion();
	Date getFecha();
	Integer getTelefono();
	Usuario getOrganizador();
	Prueba getIdprueba();
	Clubmatematicas getIdclub();
	
}
