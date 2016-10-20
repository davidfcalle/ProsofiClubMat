package com.prosofi.clubmat.webservices;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;
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
import com.prosofi.clubmat.datalayer.UsuarioRepository;
import com.prosofi.clubmat.dto.CreateTestDTO;
import com.prosofi.clubmat.entities.Pregunta;
import com.prosofi.clubmat.entities.Prueba;
import com.prosofi.clubmat.entities.Usuario;


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
	
	
	@PersistenceContext
	private EntityManager em;
	
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/api/preguntas/tipos/", produces="application/json", method = RequestMethod.GET)
	public List<String> darTiposPreguntas(){
		Query q = em.createQuery("SELECT DISTINCT p.tematica FROM Pregunta p");
		return q.getResultList();
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
		if(!create.getPrueba()){
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			String username = auth.getName();
			Usuario  u = usuarioRepository.findOneByUsuario(username);
			prueba.setIdusuario(u);
		}
		
		
		prueba = pruebaRepository.save(prueba);
		
		
		for (Pregunta pregunta : selected) {
			pregunta.getPruebaList().add(prueba);
		}
		preguntaRepository.save(selected);
		
		return new ResponseEntity<Prueba>(prueba, HttpStatus.OK);
	}
}
