package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.demo.PlanetFactory;
import com.example.demo.demo.PlanetRequest;
import com.example.demo.model.Planet;
import com.example.demo.repository.PlanetRepository;
import com.example.demo.response.PlanetResponse;

@Service
public class PlanetService {
	
	@Autowired
	private PlanetRepository planetRepository;
	
	@Autowired
	private PlanetFactory planetFactory;
	
	@Autowired
	private ApparitionsService apparitionsService;
	
	public Planet create(PlanetRequest planetRequest) {
		Planet planet = planetFactory.createNew(planetRequest);
		try {
			
			planetRepository.save(planet);
			System.out.println(planet.getId());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return planet;
	}
	
	public List<PlanetResponse> listAll() {
		
		List<Planet> planets = new ArrayList<Planet>();
		
		try {
			planets = planetRepository.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return planets.stream().map(planet -> new PlanetResponse(planet, getApparitions(planet))).collect(Collectors.toList());
		
	}	
	
	public PlanetResponse findByName(String nome) {
		
		Planet planet = new Planet();
		
		try {
			planet = planetRepository.findByNome(nome);		

		} catch (Exception e) {
			e.printStackTrace();
		}
		

			if(planet!=null) {
				
			return new PlanetResponse(planet, getApparitions(planet));
			
			}else {
				
				return null;
				
			}
		

	}

	private int getApparitions(Planet planet) {
		return apparitionsService.getApparitions(planet.getNome()).hasFilms() ? apparitionsService.getApparitions(planet.getNome()).getFilmsSize() : 0;
	}
	
	public PlanetResponse findById(String id) {
		Planet planet = new Planet();
		try {
			planet = planetRepository.findOne(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
			if(planet!=null) {
				
			return new PlanetResponse(planet, getApparitions(planet));
			
			}else {
				
				return null;
				
			}
		
	}
	
	public void delete(String id) {
			planetRepository.delete(id);

	}	

	public void setPlanetRepository(PlanetRepository planetRepository) {
		this.planetRepository = planetRepository;
	}

	public void setPlanetFactory(PlanetFactory planetFactory) {
		this.planetFactory = planetFactory;
	}

}
