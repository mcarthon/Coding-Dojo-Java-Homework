package com.codingdojo.burgerTracker.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
		
		model.addAttribute("burger", new Burger());
		
		return "home.jsp";
		
	}
	
	@PostMapping("/newBurger")
	String createBurger ( @Valid @ModelAttribute("burger") Burger burger,
					      BindingResult bindingResult,
					      Model model) {
		
		if ( bindingResult.hasErrors() ) {
			
			model.addAttribute("allBurgers", this.burgersController.allBurgers());
			
			return "home.jsp";
			
		}
		
		this.burgersController.createBurger(burger);
		
		return "redirect:/";
		
	}
	
	@GetMapping("/{id}")
	String showOneBurger ( @PathVariable("id") Long id, Model model ) {
		
		model.addAttribute( "burger", this.burgersController.oneBurger(id) );
		
		return "oneBurger.jsp";
		
	}
	
	@GetMapping("/edit/{id}")
	String editBurger ( @PathVariable("id") Long id, Model model ) {
		
		model.addAttribute( "burger", this.burgersController.oneBurger(id) );
		
		return "edit.jsp";
		
	}
	
	@PatchMapping("/edit/{id}")
	String edit ( @Valid @ModelAttribute("burger") Burger burger,
				  BindingResult bindingResult,
				  Model model,
				  @PathVariable("id") Long id) {
		
		if ( bindingResult.hasErrors() ) {
			
			return "edit.jsp";
			
		}
		
		this.burgersController.updateBurger(burger);
		
		return "redirect:/{id}";
		
	}
	
	@DeleteMapping("/delete/{id}")
	String delete(@PathVariable("id") Long id) {
		
		this.burgersController.deleteBurger(id);
		
		return "redirect:/";
		
	}

}