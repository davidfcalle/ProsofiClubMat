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

import com.prosofi.clubmat.datalayer.OlimpiadaRepository;
import com.prosofi.clubmat.datalayer.UsuarioRepository;
import com.prosofi.clubmat.entities.Olimpiada;
import com.prosofi.clubmat.entities.Usuario;

/**
 * Controlador rest las olimpiadas, crear una olimpiada con responsable usuario actual.
 * @author davidfcalle
 *
 */
@RestController
public class OlimpiadaRestController {

	
	@Autowired
	private OlimpiadaRepository olimpiadaRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	/**
	 * Método que crea una olimpiada con un usuario actual de responsable
	 */
	@RequestMapping(value="/api/olimpiada/", produces="application/json", method = RequestMethod.POST)
	public ResponseEntity<Olimpiada> crearOlimpiadaConResponsable(@RequestBody Olimpiada nueva){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		Usuario  u = usuarioRepository.findOneByUsuario(username);
		try{
			nueva.setOrganizador(u);
			nueva = olimpiadaRepository.save(nueva);
			return  new ResponseEntity<>(nueva, HttpStatus.OK);
		}catch(Exception e ){
			return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
	}
	
	/**
	 * método que permite al usuario actual suscribirse a una olimpiada
	 * @param olimpiada
	 * @return
	 */
	@RequestMapping(value="/api/olimpiada/suscribe", produces="application/json", method = RequestMethod.POST)
	public ResponseEntity<Olimpiada> suscribe(@RequestBody Olimpiada olimpiada){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		Usuario  u = usuarioRepository.findOneByUsuario(username);
		
		if(u == null)
			return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		try{
			olimpiada = olimpiadaRepository.findOne(olimpiada.getIdolimpiada());
			if(olimpiada.getUsuarioList().contains(u)){
				return  new ResponseEntity<>(HttpStatus.ALREADY_REPORTED);
			}
			olimpiada.getUsuarioList().add(u);
			olimpiada = olimpiadaRepository.save(olimpiada);
			return  new ResponseEntity<>(olimpiada, HttpStatus.OK);
		}catch(Exception e ){
			return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
	}
	
	
	/**
	 * método que permite al usuario actual suscribirse a una olimpiada
	 * @param olimpiada
	 * @return
	 */
	@RequestMapping(value="/api/olimpiada/unsuscribe", produces="application/json", method = RequestMethod.POST)
	public ResponseEntity<Olimpiada> unsuscribe(@RequestBody Olimpiada olimpiada){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		Usuario  u = usuarioRepository.findOneByUsuario(username);
		
		if(u == null)
			return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		try{
			olimpiada = olimpiadaRepository.findOne(olimpiada.getIdolimpiada());
			olimpiada.getUsuarioList().remove(u);
			olimpiada = olimpiadaRepository.save(olimpiada);
			return  new ResponseEntity<>(olimpiada, HttpStatus.OK);
		}catch(Exception e ){
			return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
	}
	
}
