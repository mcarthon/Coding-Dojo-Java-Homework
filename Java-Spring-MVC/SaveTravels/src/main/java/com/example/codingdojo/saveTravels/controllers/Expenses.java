package com.example.codingdojo.saveTravels.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Expenses {

	@GetMapping("/")
	public String rootRedirect () {
		
		return "redirect:/expenses";
		
	}
	
	@GetMapping("/expenses")
	public String home () {
		
		return "expenses.jsp";
		
	}
	
}