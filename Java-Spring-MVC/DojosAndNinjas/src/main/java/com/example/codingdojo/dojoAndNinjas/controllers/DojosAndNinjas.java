package com.example.codingdojo.dojoAndNinjas.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.codingdojo.dojoAndNinjas.models.Ninja;
import com.example.codingdojo.dojoAndNinjas.services.DojoService;
import com.example.codingdojo.dojoAndNinjas.services.NinjaService;

@Controller
public class DojosAndNinjas {
	
	private final DojoService dojoService;
	
	private final NinjaService ninjaService;
	
	public DojosAndNinjas ( DojoService dojoService, NinjaService ninjaService ) {
		
		this.dojoService = dojoService;
		
		this.ninjaService = ninjaService;
		
	}
	
	@GetMapping("/show/{id}")
	public String home ( @PathVariable ( "id" ) Long id,  Model model ) {
		
		List<Ninja> rightNinjas = new ArrayList();
		
		List<Ninja> dojoNinjas = this.ninjaService.readAll();
		
		for ( Ninja ninja: dojoNinjas ) {
			
			if ( ninja.getDojo().getId() == id ) {
				
				rightNinjas.add ( ninja );
				
			}
			
		}
		
		model.addAttribute ( "allNinjas", rightNinjas );
		
		model.addAttribute ( "dojo", this.dojoService.readOne ( id ) );
		
		return "show.jsp";
		
	}

}