package com.example.codingdojo.dojoAndNinjas.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.codingdojo.dojoAndNinjas.models.Dojo;
import com.example.codingdojo.dojoAndNinjas.services.DojoService;

import jakarta.validation.Valid;

@Controller
public class Dojos {
	
	private final DojoService dojoService;
	
	public Dojos ( DojoService dojoService ) {
		
		this.dojoService = dojoService;
		
	}
	
	@GetMapping("/")
	public String redirectToNewDojoPage () {
		
		return "redirect:/dojos";
		
	}
	
	@GetMapping("/dojos")
	public String newDojoPage ( @ModelAttribute ( "dojo" ) Dojo dojo ) {
		
		return "newDojo.jsp";
		
	}
	
	@PostMapping("/dojos")
	public String create ( @Valid @ModelAttribute ( "dojo" ) Dojo dojo, BindingResult bindingResult ) {
		
		if ( bindingResult.hasErrors() ) {
			
			return "newDojo.jsp";					
			
		}
		
		this.dojoService.create ( dojo );
		
		return "redirect:/ninjas";
		
	}

}