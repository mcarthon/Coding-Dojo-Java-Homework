package com.example.codingdojo.dojoAndNinjas.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.codingdojo.dojoAndNinjas.models.Ninja;
import com.example.codingdojo.dojoAndNinjas.services.DojoService;
import com.example.codingdojo.dojoAndNinjas.services.NinjaService;

import jakarta.validation.Valid;

@Controller
public class Ninjas {
	
	private final NinjaService ninjaService;
	
	private final DojoService dojoService;
	
	public Ninjas ( NinjaService ninjaService, DojoService dojoService ) {
		
		this.ninjaService = ninjaService;
		
		this.dojoService = dojoService;
		
	}
	
	@GetMapping("/ninjas")
	public String newNinjaPage ( @ModelAttribute ( "ninja" ) Ninja ninja, Model model ) {
		
		model.addAttribute ( "allDojos", this.dojoService.readAll() );
		
		return "newNinja.jsp";
		
	}
	
	@PostMapping("/ninjas")
	public String create ( @Valid @ModelAttribute ( "ninja" ) Ninja ninja, BindingResult bindingResult ) {
		
		if ( bindingResult.hasErrors() ) {
			
			return "newNinja.jsp";					
			
		}
		
		this.ninjaService.create ( ninja );
		
		return "redirect:/show/" + ninja.getDojo().getId();
		
	}

}