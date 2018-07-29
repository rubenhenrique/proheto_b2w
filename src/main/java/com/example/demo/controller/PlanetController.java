package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.demo.PlanetRequest;
import com.example.demo.response.PlanetResponse;
import com.example.demo.service.PlanetService;

@RestController
public class PlanetController {
	
	@Autowired
	private PlanetService planetService;
	
	@RequestMapping(value = "/planet", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<?> createPlanet(@RequestBody @Valid PlanetRequest planetRequest) {
		
		planetService.create(planetRequest);
		return new ResponseEntity<>("Planeta criado com sucesso", HttpStatus.CREATED);
		
		
	}

	@RequestMapping(method = RequestMethod.GET, value = "/planet/{planetaId}")
	public ResponseEntity<?> getPlanetakDetails(@PathVariable("planetaId") String planetaId) {
		
		PlanetResponse planetResponse=  planetService.findById(planetaId);
		
		if(planetResponse!=null) {
			
			return new ResponseEntity<>(planetResponse, HttpStatus.CREATED);
			
		}else {
			
			return new ResponseEntity<>("Id de Planeta não encontrado.", HttpStatus.EXPECTATION_FAILED);
		}
		

	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/planet")
	public ResponseEntity<?> getPlanetByName(@RequestParam(value = "nome") String nome) {
		
		PlanetResponse planetResponse= planetService.findByName(nome);
		
		if(planetResponse!=null) {
		
			return new ResponseEntity<>(planetResponse, HttpStatus.CREATED);
			
		}else {
			
			return new ResponseEntity<>("Planeta não encontrado.", HttpStatus.EXPECTATION_FAILED);
		}

	}
	
	@RequestMapping(value = "/planet/all", method = RequestMethod.GET)
	public List<PlanetResponse> getAllPlanets() {
		return planetService.listAll();

	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "planet/{planetaId}")
	public ResponseEntity<?>  deletePlanet(@PathVariable("planetaId") String planetaId) {
				
				PlanetResponse planetResponse=  planetService.findById(planetaId);
		
				if(planetResponse!=null) {
					
				planetService.delete(planetaId);
				
					return new ResponseEntity<>("Planeta excluído com sucesso.", HttpStatus.CREATED);
				
				}else {
					
					return new ResponseEntity<>("Id de Planeta inexistente.", HttpStatus.EXPECTATION_FAILED);
					
				}

					
	}

}
