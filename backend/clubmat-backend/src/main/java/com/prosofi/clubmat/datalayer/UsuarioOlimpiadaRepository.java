package com.prosofi.clubmat.datalayer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.prosofi.clubmat.entities.UsuarioOlimpiada;

@RepositoryRestResource( path="/usuarioolimpiada" , itemResourceRel = "usuariolimpiada", collectionResourceRel ="usuarioslimpiada") 
public interface UsuarioOlimpiadaRepository extends JpaRepository<UsuarioOlimpiada, Integer> {

}
