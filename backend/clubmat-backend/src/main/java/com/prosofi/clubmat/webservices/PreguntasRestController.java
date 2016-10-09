package com.prosofi.clubmat.webservices;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.prosofi.clubmat.entities.Pregunta;

/**
 * Controlador Rest para las preguntas, se utiliza cuando los rest repositories generados no son sufuciente
 * @author david.calle
 *
 */
@RestController
public class PreguntasRestController {
	
	
	@RequestMapping(value="/api/preguntas/" , method = RequestMethod.POST , produces = "application/json" )
	public  ResponseEntity<?> createPregunta(@RequestBody Pregunta pregunta){
		//se remueven las preguntas para que se pueda guardar
		return null;
	}
}
