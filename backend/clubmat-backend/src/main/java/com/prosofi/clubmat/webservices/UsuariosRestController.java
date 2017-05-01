package com.prosofi.clubmat.webservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.prosofi.clubmat.datalayer.ClubMatetameticasReposity;
import com.prosofi.clubmat.datalayer.UsuarioRepository;
import com.prosofi.clubmat.entities.Clubmatematicas;
import com.prosofi.clubmat.entities.Usuario;


/**
 * Controlador rest para la informacion del usuario
 * @author david.calle
 *
 */
@RestController
public class UsuariosRestController {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private ClubMatetameticasReposity clubRepository;
	
	
	/**
	 * método que retorna la información del usuario que está actualmente
	 * autenticado
	 * @return información del usuario actual
	 */
	@RequestMapping(value="/api/currentUser/", produces="application/json", method = RequestMethod.GET)
	public ResponseEntity<Usuario> darInformacionUsuario(){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		Usuario  u = usuarioRepository.findOneByUsuario(username);
		return  new ResponseEntity<>(u, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/api/user/create", produces = "application/json", method=RequestMethod.POST)
	public ResponseEntity<?> createUsuario (@RequestBody Usuario usuario, Integer idclub){
		if(idclub == null)
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		Clubmatematicas club = clubRepository.findOne(idclub);
		usuario.setIdclub(club);
		usuario = usuarioRepository.save(usuario);
		club.getUsuarioList().add(usuario);
		clubRepository.save(club);
		
		return new ResponseEntity<Usuario>(usuario,HttpStatus.OK);
	}
}
