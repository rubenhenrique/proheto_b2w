package com.example.demo.response;

import java.util.List;

import com.example.demo.demo.Result;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ApparitionsResponse {
	
	private List<Result> results;

	public List<Result> getResults() {
		return results;
	}

	public void setResults(List<Result> results) {
		this.results = results;
	}
	
	public boolean hasFilms() {
		return hasResults() && !results.stream().findFirst().get().getFilms().isEmpty();
	}
	
	public boolean hasResults() {
		return !results.isEmpty();
	}
	
	public int getFilmsSize() {
		return results.stream().findFirst().get().getFilms().size();
	}

}
