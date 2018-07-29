package com.example.demo.service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.response.ApparitionsResponse;

@Service
public class ApparitionsService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	public ApparitionsResponse getApparitions(String nomePlaneta) {
		try {
			return restTemplate.exchange(getUrl(nomePlaneta),
					HttpMethod.GET, new HttpEntity<>(getApparitionsHeaders()), ApparitionsResponse.class).getBody();			
		} catch(Exception e) {
			System.out.println("Erro ao chamar api de planetas: " + getUrl(nomePlaneta));
			throw e;
		}
	}
	
	private String getUrl(String nomePlaneta){
		return "https://swapi.co/api/planets/?search=" + nomePlaneta;
	}

	private HttpHeaders getApparitionsHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10.12; rv:55.0) Gecko/20100101 Firefox/55.0");
		return headers;
	}

}
