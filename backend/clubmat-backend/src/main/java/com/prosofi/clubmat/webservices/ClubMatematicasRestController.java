package com.prosofi.clubmat.webservices;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.prosofi.clubmat.datalayer.ClubMatetameticasReposity;
import com.prosofi.clubmat.datalayer.InstitucionRepository;
import com.prosofi.clubmat.dto.ClubMatematicaDTO;
import com.prosofi.clubmat.entities.Clubmatematicas;
import com.prosofi.clubmat.entities.Institucion;

@RestController
public class ClubMatematicasRestController {
	
	@Autowired
	private ClubMatetameticasReposity clubMatematicasRepository;
	
	@Autowired
	private InstitucionRepository institucionRepository;
	
	@RequestMapping(value="/api/mathclub", produces="application/json", method = RequestMethod.GET)
	public ResponseEntity<?> getClubs(){
		List<Clubmatematicas> clubs = clubMatematicasRepository.findAll();
		List<ClubMatematicaDTO> clubsDTO = new ArrayList<>();
		for (Clubmatematicas clubmatematicas : clubs) {
			ClubMatematicaDTO clubDTO = new ClubMatematicaDTO();
			clubDTO.setIdclub(clubmatematicas.getIdclub());
			clubDTO.setNombre(clubmatematicas.getNombreclub());
			if(clubmatematicas.getIdinstitucion() != null)
				clubDTO.setInstitucion(clubmatematicas.getIdinstitucion().getNombre());
			clubDTO.setLema(clubmatematicas.getLema());
			clubsDTO.add(clubDTO);
		}
		return new ResponseEntity<List<ClubMatematicaDTO>>(clubsDTO,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/api/mathclub/create", produces="application/json", method=RequestMethod.POST)
	public ResponseEntity<?> createClub(@RequestBody Clubmatematicas club,Integer idinstitucion){
		if(idinstitucion == null)
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		Institucion institucion = institucionRepository
				.findOne(idinstitucion);
		
		club.setIdinstitucion(institucion);
		club = clubMatematicasRepository.save(club);
		institucion.getClubmatematicasList().add(club);
		
		institucion = institucionRepository.save(institucion);
		
		return new ResponseEntity<Clubmatematicas>(club,HttpStatus.OK);
	}

}
