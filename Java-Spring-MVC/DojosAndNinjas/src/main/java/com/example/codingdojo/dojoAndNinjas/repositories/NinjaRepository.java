package com.example.codingdojo.dojoAndNinjas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.codingdojo.dojoAndNinjas.models.Ninja;

public interface NinjaRepository extends CrudRepository<Ninja, Long> {
	
	List<Ninja> findAll();

}
