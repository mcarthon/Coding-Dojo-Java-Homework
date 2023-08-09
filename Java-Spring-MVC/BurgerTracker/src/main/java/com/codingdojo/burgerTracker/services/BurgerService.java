package com.codingdojo.burgerTracker.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.burgerTracker.models.Burger;
import com.codingdojo.burgerTracker.repositories.BurgerRepository;

@Service
public class BurgerService {

	private final BurgerRepository burgerRepository;
	
	public BurgerService ( BurgerRepository burgerRepository ) {
		
		this.burgerRepository = burgerRepository;
		
	}
	
	public List<Burger> allBurgers () {
		
		return this.burgerRepository.findAll();
		
	}
	
	public Burger oneBurger ( Long id ) {
		
		Optional<Burger> optionalBurger = this.burgerRepository.findById(id);
		
		if ( optionalBurger.isPresent() ) {
			
			return optionalBurger.get();
			
		}
		
		return null;
		
	}
	
	public Burger createBurger ( Burger burger ) {
		
		return this.burgerRepository.save( burger );
		
	}
	
	public Burger updateBurger ( Burger burger ) {
		
		return this.burgerRepository.save( burger );
		
	}
	
	public String deleteBurger ( Long id ) {
		
		this.burgerRepository.deleteById ( id );
		
		return String.format( "Burger with id %d has been successfully deleted.", id );
		
	}
	
}