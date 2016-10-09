package com.prosofi.clubmat.webservices;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.prosofi.clubmat.datalayer.OpcionPreguntaRepository;
import com.prosofi.clubmat.datalayer.PreguntaRepository;
import com.prosofi.clubmat.entities.Opcionpregunta;
import com.prosofi.clubmat.entities.Pregunta;

/**
 * Controlador Rest para las preguntas, se utiliza cuando los rest repositories generados no son sufuciente
 * @author david.calle
 *
 */
@RestController
public class PreguntasRestController {
	
	@Autowired
	private PreguntaRepository preguntaRepository;
	
	@Autowired
	private OpcionPreguntaRepository opRepository;
	
	@RequestMapping(value={"/api/preguntas/","/api/preguntas"} , method = RequestMethod.POST , produces = "application/json" )
	public  ResponseEntity<?> createPregunta(@RequestBody Pregunta pregunta){
		try{
			System.out.println(pregunta);
			ArrayList<Opcionpregunta> questions = new ArrayList<>(pregunta.getOpcionpreguntaList());
			pregunta = preguntaRepository.save(pregunta);
			for (Opcionpregunta opcion: questions) {
				opcion.setIdpregunta(pregunta);
				opcion = opRepository.save(opcion);
			}
			pregunta.setOpcionpreguntaList(questions);
			return new ResponseEntity<Pregunta>(pregunta, HttpStatus.OK);
		}catch(Exception e){
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
}
