package com.example.demo.response;

import com.example.demo.model.Planet;

public class PlanetResponse {
	
	private String nome;
	private String clima;
	private String terreno;
	private int apparitions;
	
	public PlanetResponse(Planet planet, int apparitions) {
		this.nome = planet.getNome();
		this.clima = planet.getClima();
		this.terreno = planet.getTerreno();
		this.apparitions = apparitions;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getClima() {
		return clima;
	}
	public void setClima(String clima) {
		this.clima = clima;
	}
	public String getTerreno() {
		return terreno;
	}
	public void setTerreno(String terreno) {
		this.terreno = terreno;
	}

	public int getApparitions() {
		return apparitions;
	}

	public void setApparitions(int apparitions) {
		this.apparitions = apparitions;
	}

}
