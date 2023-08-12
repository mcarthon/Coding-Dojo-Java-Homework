package com.example.codingdojo.dojoAndNinjas.services;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.codingdojo.dojoAndNinjas.models.Dojo;
import com.example.codingdojo.dojoAndNinjas.repositories.DojoRepository;

@RestController
@RequestMapping("/api")
public class DojoService {
	
	private final DojoRepository dojoRepository;
	
	public DojoService ( DojoRepository dojoRepository ) {
		
		this.dojoRepository = dojoRepository;
		
	}
	
	public Dojo create ( Dojo dojo ) {
		
		 this.dojoRepository.save( dojo );
		
	}
	
	public List<Dojo> readAll () {
		
		return this.dojoRepository.findAll();
		
	}
	
	public Dojo readOne ( + )

}