package com.prosofi.clubmat.datalayer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.prosofi.clubmat.entities.Institucion;

@RepositoryRestResource( path="/institucion" , itemResourceRel = "institucion", collectionResourceRel ="instituciones") 
public interface InstitucionRepository extends JpaRepository<Institucion, Integer> {

}
