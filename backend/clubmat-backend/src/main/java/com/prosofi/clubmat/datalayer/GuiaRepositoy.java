package com.prosofi.clubmat.datalayer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.prosofi.clubmat.entities.Guia;

@RepositoryRestResource( path="/guia" , itemResourceRel = "guia", collectionResourceRel ="guias") 
public interface GuiaRepositoy extends JpaRepository<Guia, Integer> {

}
