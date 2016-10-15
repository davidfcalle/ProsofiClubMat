package com.prosofi.clubmat.datalayer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.prosofi.clubmat.entities.Olimpiada;

@RepositoryRestResource( path="/olimpiada" , itemResourceRel = "olimpiada", collectionResourceRel ="olimpiadas") 
public interface OlimpiadaRepository extends JpaRepository<Olimpiada, Integer> {

}
