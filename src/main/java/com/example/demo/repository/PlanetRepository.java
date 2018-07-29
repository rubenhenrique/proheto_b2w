package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Planet;

public interface PlanetRepository extends MongoRepository<Planet, String>{

	@Query
	Planet findByNome(@Param(value = "nome") String nome);

}
