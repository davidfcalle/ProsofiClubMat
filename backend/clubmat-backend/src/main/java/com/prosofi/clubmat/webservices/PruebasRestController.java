package com.prosofi.clubmat.webservices;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.prosofi.clubmat.datalayer.PreguntaRepository;
import com.prosofi.clubmat.datalayer.PruebaRepository;
import com.prosofi.clubmat.datalayer.UsuarioPruebaRepository;
import com.prosofi.clubmat.datalayer.UsuarioRepository;
import com.prosofi.clubmat.dto.CreateTestDTO;
import com.prosofi.clubmat.entities.Pregunta;
import com.prosofi.clubmat.entities.Prueba;
import com.prosofi.clubmat.entities.Usuario;
import com.prosofi.clubmat.entities.UsuarioPrueba;


/**
 * Controlador rest para la informacion de las pregunas
 * @author davidfcalle
 *
 */
@RestController
public class PruebasRestController {

	
	@Autowired
	private PreguntaRepository preguntaRepository;
	
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private PruebaRepository pruebaRepository;
	
	@Autowired
	private UsuarioPruebaRepository usuarioPruebaRepository;
	
	
	@PersistenceContext
	private EntityManager em;
	
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/api/preguntas/tipos/", produces="application/json", method = RequestMethod.GET)
	public List<String> darTiposPreguntas(){
		Query q = em.createQuery("SELECT DISTINCT p.tematica FROM Pregunta p");
		return q.getResultList();
	}
	
	public Prueba crearPrueba(Integer grade){
		List<Pregunta> opcionadas = (List<Pregunta>)em.createQuery("select p from Pregunta p where p.nivelacademico = :lvacadmico")
				.setParameter("lvacadmico", grade+"")
				.getResultList();
		
		if(opcionadas != null && opcionadas.isEmpty())
			return null;
		
		Prueba prueba = new Prueba();
		prueba.setUsuariosList(new ArrayList<>());
		
		long seed = System.nanoTime();
		Collections.shuffle(opcionadas, new Random(seed));
		
		List<Pregunta> selected = new ArrayList<>();
		
		for(int i = 0; i < opcionadas.size(); i++){
			selected.add(opcionadas.get(i));
		}
		
		
		prueba.setFecha(new Date());
		prueba.setNumcorrectas(0);
		prueba.setNumpreguntas(selected.size());
		prueba.setTema("Olimpiada");
		
		prueba = pruebaRepository.save(prueba);
		
		
		for (Pregunta pregunta : selected) {
			pregunta.getPruebaList().add(prueba);
		}
		
		preguntaRepository.save(selected);
		return prueba;
	}
	
	/**
	 * método que retorna la información del usuario que está actualmente
	 * autenticado
	 * @return información del usuario actual
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/api/test/", produces="application/json", method = RequestMethod.POST)
	public ResponseEntity<Prueba> crearPreguntas(@RequestBody CreateTestDTO create){
		
		List<Pregunta> opcionadas = (List<Pregunta>)em.createQuery("select p from Pregunta p where p.dificultad = :dificultad and p.nivelacademico = :lvacadmico and p.tematica = :tema")
					.setParameter("dificultad", create.getDificultad())
					.setParameter("lvacadmico", create.getGrado()+"")
					.setParameter("tema", create.getTema())
					.getResultList();
		
		if(opcionadas.size() < create.getNumpreguntas()){
			return new ResponseEntity<Prueba>(HttpStatus.BAD_REQUEST);
		}
		
		
		Prueba prueba = new Prueba();
		
		long seed = System.nanoTime();
		Collections.shuffle(opcionadas, new Random(seed));
		
		List<Pregunta> selected = new ArrayList<>();
		
		for(int i = 0; i < create.getNumpreguntas(); i++){
			selected.add(opcionadas.get(i));
		}
		
		
		prueba.setFecha(create.getFecha());
		prueba.setNumcorrectas(0);
		prueba.setNumpreguntas(create.getNumpreguntas());
		prueba.setTema(create.getTema());
		
		//si se quiere guardar la prueba se le debe asociar un usuario.
//		if(!create.getPrueba()){
//			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//			String username = auth.getName();
//			Usuario  u = usuarioRepository.findOneByUsuario(username);
//		}
		
		
		prueba = pruebaRepository.save(prueba);
		
		
		for (Pregunta pregunta : selected) {
			pregunta.getPruebaList().add(prueba);
		}
		preguntaRepository.save(selected);
		
		return new ResponseEntity<Prueba>(prueba, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/api/test",produces="application/json", method = RequestMethod.PUT)
	public ResponseEntity<?> updatePrueba(@RequestBody Prueba prueba){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		Usuario  u = usuarioRepository.findOneByUsuario(username);
		
		UsuarioPrueba usuarioPrueba = new UsuarioPrueba();
		usuarioPrueba.setIdprueba(prueba.getIdprueba());
		usuarioPrueba.setIdusuario(u.getIdusuario());
		usuarioPrueba.setNumCorrectas(prueba.getNumcorrectas());
		
		prueba = pruebaRepository.findOne(prueba.getIdprueba());
		
		usuarioPrueba = usuarioPruebaRepository.save(usuarioPrueba);
		if(u.getPruebasList() == null)
			u.setPruebasList(new ArrayList<>());
		u.getPruebasList().add(usuarioPrueba);
		u = usuarioRepository.save(u);
		
		if(prueba.getUsuariosList() == null)
			prueba.setUsuariosList(new ArrayList<>());
		prueba.getUsuariosList().add(usuarioPrueba);
		prueba = pruebaRepository.save(prueba);
		return new ResponseEntity<Prueba>(prueba,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/api/test/hastaken",produces="application/json", method = RequestMethod.GET)
	public ResponseEntity<?> hasTaken(Integer id){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		Usuario  u = usuarioRepository.findOneByUsuario(username);
		
		if(u == null || id == null)
			return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		StringBuilder sql = new StringBuilder("SELECT usu ")
				.append("FROM UsuarioPrueba usu ")
				.append("WHERE usu.idusuario = :idusuario ")
				.append("AND usu.idprueba = :idprueba");
		try{
			UsuarioPrueba usuarioPrueba = (UsuarioPrueba)em.createQuery(sql.toString())
					.setParameter("idusuario", u.getIdusuario())
					.setParameter("idprueba", id)
					.getSingleResult();
			if(usuarioPrueba == null)
				return  new ResponseEntity<>(new HashMap<String,Boolean>(){{put("value",false);}}, HttpStatus.OK);
			return new ResponseEntity<Object>(new HashMap<String,Boolean>(){{put("value",true);}},HttpStatus.OK);
		}catch(NoResultException ex){
			return  new ResponseEntity<>(new HashMap<String,Boolean>(){{put("value",false);}}, HttpStatus.OK);
		}catch(Exception e ){
			return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
}
