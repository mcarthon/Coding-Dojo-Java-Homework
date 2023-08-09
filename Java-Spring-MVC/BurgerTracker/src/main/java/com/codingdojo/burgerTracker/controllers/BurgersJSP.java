package com.codingdojo.burgerTracker.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.burgerTracker.models.Burger;

import jakarta.validation.Valid;

@Controller
public class BurgersJSP {
	
	private final Burgers burgersController;
	
	public BurgersJSP ( Burgers burgersController ) {
		
		this.burgersController = burgersController;
		
	}
	
	@GetMapping("/")
	String home ( Model model ) {			
		
		model.addAttribute("allBurgers", this.burgersController.allBurgers());
		
		model.addAttribute("newBurger", new Burger());
		
		return "home.jsp";
		
	}
	
	@PostMapping("/newBurger")
	String createBurger ( @Valid @ModelAttribute("newBurger") Burger newBurger,
					      BindingResult bindingResult,
					      Model model) {
		
		if ( bindingResult.hasErrors() ) {
			
			model.addAttribute("allBurgers", this.burgersController.allBurgers());
			
			return "home.jsp";
			
		}
		
		this.burgersController.createBurger(newBurger);
		
		return "redirect:/";
		
	}

}