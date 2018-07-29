package com.example.demo.demo;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PlanetRequest {
	
	@NotBlank(message = "{nome.not.blank}")
	private String nome;
	@NotBlank(message = "{clima.not.blank}")
	private String clima;
	@NotBlank(message = "{terreno.not.blank}")
	private String terreno;
	
	public String getNome() {
		return nome;
	}
	
	public String getClima() {
		return clima;
	}
	
	public String getTerreno() {
		return terreno;
	}
	
	
}
