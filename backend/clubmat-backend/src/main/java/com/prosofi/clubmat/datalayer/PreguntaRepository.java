package com.prosofi.clubmat.datalayer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.prosofi.clubmat.entities.Pregunta;

@RepositoryRestResource( path="/pregunta" , itemResourceRel = "pregunta", collectionResourceRel ="preguntas") 
public interface PreguntaRepository extends JpaRepository<Pregunta, Integer> {

}
