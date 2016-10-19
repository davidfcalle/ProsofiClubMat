package com.prosofi.clubmat.webservices;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
import com.prosofi.clubmat.entities.Institucion;
import com.prosofi.clubmat.entities.Pregunta;
import com.prosofi.clubmat.entities.Prueba;
import com.prosofi.clubmat.entities.Usuario;


/**
 * Controlador rest para la informacion del usuario
 * @author david.calle
 *
 */
@RestController
public class PruebasRestController {

	@Autowired
	private PreguntaRepository preguntaRepository;
	@Autowired
	private PruebaRepository pruebaRepository;
	@PersistenceContext
	private EntityManager em;
	
	/**
	 * método que retorna la información del usuario que está actualmente
	 * autenticado
	 * @return información del usuario actual
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/api/nuevaPrueba/", produces="application/json", method = RequestMethod.POST)
	public ResponseEntity<List<Pregunta>> crearPreguntas(@RequestBody Prueba incomp){
		
	List<Pregunta> opcionadas = (List<Pregunta>)em.createQuery("select p from Pregunta p where p.dificultad = :dificultad and p.nivelacademico = :lvacadmico and p.tematica = :tema")
				.setParameter("dificultad", "media")
				.setParameter("lvacademico", 4)
				.setParameter("tema","sumas")
				.getResultList();
	
	Prueba pruebaSelected = pruebaRepository.findOne(incomp.getIdprueba());
	
	return new ResponseEntity<List<Pregunta>>(opcionadas,HttpStatus.OK);

	}
}
