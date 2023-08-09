package com.codingdojo.burgerTracker.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codingdojo.burgerTracker.models.Burger;
import com.codingdojo.burgerTracker.services.BurgerService;

@RestController
@RequestMapping("/api")
public class Burgers {

	private final BurgerService burgerService;

	public Burgers ( BurgerService burgerService ) {
		
		this.burgerService = burgerService;
		
	}
	
	@GetMapping("/burgers")
	List<Burger> allBurgers () {
		
		return this.burgerService.allBurgers();
		
	}
	
	@GetMapping("/burgers/{id}")
	public Burger oneBurger ( Long id ) {
		
		return this.burgerService.oneBurger(id);
		
	}
	
	@PostMapping("/burgers")
	public Burger createBurger ( Burger burger ) {
		
		return this.burgerService.createBurger(burger);
		
	}
	
	@PatchMapping("/burgers/{id}")
	public Burger updateBurger ( Burger burger ) {
		
		return this.burgerService.updateBurger(burger);
		
	}
	
	@DeleteMapping("/burgers/{id}")
	public String deleteBurger ( Long id ) {
		
		return this.burgerService.deleteBurger(id);
		
	}
	
}