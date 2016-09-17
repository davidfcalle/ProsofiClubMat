package com.prosofi.clubmat.datalayer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.prosofi.clubmat.entities.Opcionpregunta;

@RepositoryRestResource( path="/opcionpregunta" , itemResourceRel = "opcionpregunta", collectionResourceRel ="opcionespregunta") 
public interface OpcionPreguntaRepository extends JpaRepository<Opcionpregunta, Integer> {

}
