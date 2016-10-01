package com.prosofi.clubmat.datalayer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.prosofi.clubmat.entities.Usuario;

@RepositoryRestResource( path="/usuario" , itemResourceRel = "usuario", collectionResourceRel ="usuarios") 
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	public Usuario findOneByUsuario(String usuario);
	
}
