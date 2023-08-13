package com.example.codingdojo.dojoAndNinjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.codingdojo.dojoAndNinjas.models.Dojo;
import com.example.codingdojo.dojoAndNinjas.repositories.DojoRepository;

@Service
@RequestMapping("/api")
public class DojoService {
	
	private final DojoRepository dojoRepository;
	
	public DojoService ( DojoRepository dojoRepository ) {
		
		this.dojoRepository = dojoRepository;
		
	}
	
	public Dojo create ( Dojo dojo ) {
		
		 return this.dojoRepository.save( dojo );
		
	}
	
	public List<Dojo> readAll () {
		
		return this.dojoRepository.findAll();
		
	}
	
	public Dojo readOne ( Long id ) {
		
		Optional<Dojo> optionalDojo = this.dojoRepository.findById ( id );
		
		if ( optionalDojo.isPresent() ) {
			
			return optionalDojo.get();
			
		}
		
		return null;
		
	}
	
	public Dojo update ( Dojo dojo ) {
		
		return this.dojoRepository.save ( dojo );
		
	}
	
	public void delete ( Long id ) {
		
		this.dojoRepository.deleteById ( id );
		
	}

}