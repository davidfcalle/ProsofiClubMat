package com.prosofi.clubmat.webservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.prosofi.clubmat.datalayer.InstitucionRepository;
import com.prosofi.clubmat.entities.Institucion;

@RestController
public class InstitucionesRestController {

	@Autowired
	private InstitucionRepository institucionRepository;
	
	
	
	@RequestMapping(value="/api/instituciones/" , method = RequestMethod.POST , produces = "application/json" )
	public  ResponseEntity<?> createInstitucion(@RequestBody Institucion institution){
		if(institution.getIdinstitucion() != null){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		try{
		   institucionRepository.save(institution);
		}catch(Exception e){
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<Institucion>(institution, HttpStatus.OK);
	}
	
	@RequestMapping(value="/api/instituciones/" , method = RequestMethod.PUT , produces = "application/json" )
	public  ResponseEntity<?> updateInstitucion(@RequestBody Institucion institution){
		if(institution.getIdinstitucion() == null){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		try{
		   institucionRepository.save(institution);
		}catch(Exception e){
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Institucion>(institution, HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/api/instituciones/" , method = RequestMethod.DELETE , produces = "application/json" )
	public  ResponseEntity<?> deleteInstitucion(@RequestBody Institucion institution){
		if(institution.getIdinstitucion() == null){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		try{
		   institucionRepository.delete(institution);
		}catch(Exception e){
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Institucion>(institution, HttpStatus.OK);
	}
	
	
	
}
