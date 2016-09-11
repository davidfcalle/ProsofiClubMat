package com.prosofi.clubmat.datalayer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.prosofi.clubmat.entities.Clubmatematicas;

@RepositoryRestResource( path="/club" , itemResourceRel = "club", collectionResourceRel ="clubes") 
public interface ClubMatetameticasReposity extends JpaRepository<Clubmatematicas, Integer> {

}
