package com.prosofi.clubmat.webservices;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
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

import com.prosofi.clubmat.datalayer.OlimpiadaRepository;
import com.prosofi.clubmat.datalayer.UsuarioRepository;
import com.prosofi.clubmat.dto.ResultsDTO;
import com.prosofi.clubmat.entities.Olimpiada;
import com.prosofi.clubmat.entities.Prueba;
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
	
	@Autowired
	private PruebasRestController pruebaController;
	
	@PersistenceContext
	private EntityManager em;
	
	
	/**
	 * Método que crea una olimpiada con un usuario actual de responsable
	 */
	@RequestMapping(value="/api/olimpiadas", produces="application/json", method = RequestMethod.POST)
	public ResponseEntity<Olimpiada> crearOlimpiadaConResponsable(
			@RequestBody Olimpiada nueva,
			Integer grade){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		Usuario  u = usuarioRepository.findOneByUsuario(username);
		Prueba prueba = null;
		try{
			nueva.setOrganizador(u);
			
			if(grade != null){
				prueba = pruebaController.crearPrueba(grade,20);
			}
			if(prueba == null)
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			nueva.setIdprueba(prueba);
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
	
	@RequestMapping(value="/api/olimpiada/issuscribe", produces="application/json", method = RequestMethod.GET)
	public ResponseEntity<Object> isSuscribe(Integer id){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		Usuario  u = usuarioRepository.findOneByUsuario(username);
		
		if(u == null || id == null)
			return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		try{
			Olimpiada olimpiada = olimpiadaRepository.findOne(id);
			for(Usuario user: olimpiada.getUsuarioList()){
				if(user.getIdusuario() == u.getIdusuario())
					return new ResponseEntity<Object>(new HashMap<String,Boolean>(){{put("value",true);}},HttpStatus.OK);
			}
			return  new ResponseEntity<>(new HashMap<String,Boolean>(){{put("value",false);}}, HttpStatus.OK);
		}catch(Exception e ){
			return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value="/api/olimpiada/results", produces="application/json", method = RequestMethod.GET)
	public ResponseEntity<?> getResults(Integer idolympiad){
		Olimpiada olimpiada = olimpiadaRepository.findOne(idolympiad);
		
		List<ResultsDTO> listResults = new ArrayList<>();
		
		StringBuilder sql = new StringBuilder("SELECT usu.num_correctas AS numCorrectas, u.nombre AS nombreEstudiante, ")
				.append("u.apellido AS apellidoEstudiante, cl.nombreclub AS club, inst.nombre AS institucion, usu.time ")
				.append("FROM usuarioprueba usu, usuario u, clubmatematicas cl, institucion inst ")
				.append("WHERE usu.idprueba = :idprueba ")
				.append("AND usu.idusuario = u.idusuario ")
				.append("AND cl.idinstitucion = inst.idinstitucion ")
				.append("AND u.idclub = cl.idclub ")
				.append("ORDER BY usu.num_correctas DESC, usu.time");
		
		try{
			List<Object[]> list = em.createNativeQuery(sql.toString())
					.setParameter("idprueba", olimpiada.getIdprueba().getIdprueba())
					.getResultList();
			for (Object[] object : list) {
				ResultsDTO result = new ResultsDTO();
				result.setNumCorrectas((Integer)object[0]);
				result.setNombreEstudiante((String)object[1]);
				result.setApellidoEstudiante((String)object[2]);
				result.setClub((String)object[3]);
				result.setInstitucion((String)object[4]);
				result.setDuracion(formatearTiempo((BigInteger)object[5]));
				listResults.add(result);
			}
			return new ResponseEntity<List<ResultsDTO>>(listResults,HttpStatus.OK);
		}catch(NoResultException ex){
			return new ResponseEntity<Object>(new ArrayList<>(),HttpStatus.OK);
		}
	}
	
	private String formatearTiempo(BigInteger time){
		StringBuilder tiempoFormateado = new StringBuilder();
		// convert time to seconds
		Integer tiempo = time.intValue() / 1000;
		Integer minutos = tiempo/60;
		if(minutos >= 60){
			// Hours
			Integer horas = minutos / 60;
			minutos = minutos - (horas*60);
			Integer segundos = tiempo - ((horas*60*60)+(minutos*60));
			tiempoFormateado.append(horas<10?"0"+horas:horas.toString())
				.append(":")
				.append(minutos<10?"0"+minutos:minutos.toString())
				.append(":")
				.append(segundos<10?"0"+segundos:segundos.toString());
		}else{
			tiempoFormateado.append("00:");
			Integer segundos = tiempo - (minutos*60);
			tiempoFormateado.append(minutos<10?"0"+minutos:minutos.toString())
				.append(":")
				.append(segundos<10?"0"+segundos:segundos.toString());		
		}
		return tiempoFormateado.toString();
	}
	
}
