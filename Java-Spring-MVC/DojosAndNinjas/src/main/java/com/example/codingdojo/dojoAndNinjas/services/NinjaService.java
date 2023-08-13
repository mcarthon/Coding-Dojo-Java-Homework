package com.example.codingdojo.dojoAndNinjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.codingdojo.dojoAndNinjas.models.Ninja;
import com.example.codingdojo.dojoAndNinjas.repositories.NinjaRepository;

@Service
@RequestMapping("/api")
public class NinjaService {
	
	private final NinjaRepository ninjaRepository;
	
	public NinjaService ( NinjaRepository ninjaRepository ) {
		
		this.ninjaRepository = ninjaRepository;
		
	}
	
	public Ninja create ( Ninja ninja ) {
		
		return this.ninjaRepository.save ( ninja );
		
	}
	
	public List<Ninja> readAll () {
		
		return this.ninjaRepository.findAll ();
		
	}
	
	public Ninja readOne ( Long id ) {
		
		Optional<Ninja> optionalNinja = this.ninjaRepository.findById ( id );
		
		if ( optionalNinja.isPresent() ) {
			
			return optionalNinja.get ();
			
		}
		
		return null;
		
	}
	
	public Ninja update ( Ninja ninja ) {
		
		return this.ninjaRepository.save ( ninja );
		
	}
	
	public void delete ( Long id ) {
		
		this.ninjaRepository.deleteById ( id );
		
	}
 
}