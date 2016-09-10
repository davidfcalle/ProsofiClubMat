package com.prosofi.clubmat.datalayer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.prosofi.clubmat.entities.Prueba;

@RepositoryRestResource( path="/prueba" , itemResourceRel = "prueba", collectionResourceRel ="pruebas") 
public interface PruebaRepository extends JpaRepository<Prueba, Integer> {

}
