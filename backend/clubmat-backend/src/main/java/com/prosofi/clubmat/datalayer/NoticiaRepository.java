package com.prosofi.clubmat.datalayer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.prosofi.clubmat.entities.Noticia;

@RepositoryRestResource( path="/noticia" , itemResourceRel = "noticia", collectionResourceRel ="noticias") 
public interface NoticiaRepository extends JpaRepository<Noticia, Integer> {

}
