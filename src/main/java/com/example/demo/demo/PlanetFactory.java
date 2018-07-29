package com.example.demo.demo;

import org.springframework.stereotype.Service;

import com.example.demo.model.Planet;

@Service
public class PlanetFactory {
	
	public Planet createNew(PlanetRequest planetRequest) {
		Planet planet = new Planet();
		planet.setNome(planetRequest.getNome());
		planet.setClima(planetRequest.getClima());
		planet.setTerreno(planetRequest.getTerreno());
		
		return planet;
	}

}
