package com.prosofi.clubmat.projections;

import java.util.List;

import org.springframework.data.rest.core.config.Projection;

import com.prosofi.clubmat.entities.Opcionpregunta;
import com.prosofi.clubmat.entities.Pregunta;

@Projection(name="preguntas", types = { Pregunta.class })
public interface PreguntaOpcionProjection {
	
	Integer getIdpregunta();
    String getTitulo();
    String getAprobado();
    String getResultado();
    String getClasificacion();
    String getNivelacademico();
    String getTematica();
    String getDificultad();
    String getEnunciado();
    List<Opcionpregunta> getOpcionpreguntaList();
    
    
}
