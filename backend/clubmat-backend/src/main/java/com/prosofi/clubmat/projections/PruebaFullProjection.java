package com.prosofi.clubmat.projections;

import java.util.Date;
import java.util.List;

import org.springframework.data.rest.core.config.Projection;

import com.prosofi.clubmat.entities.Pregunta;
import com.prosofi.clubmat.entities.Prueba;


@Projection(name="preguntas", types = {Prueba.class})
public interface PruebaFullProjection {
	
	public Integer getIdprueba();
    public Date getFecha();
    public String getTema();
    public Integer getNumpreguntas();
    public Integer getNumcorrectas();
    public String getTipoprueba();
    public List<Pregunta> getPreguntaList();

    
}
