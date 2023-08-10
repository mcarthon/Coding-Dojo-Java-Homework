package com.example.codingdojo.saveTravels.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.codingdojo.saveTravels.models.Expense;
import com.example.codingdojo.saveTravels.services.ExpenseService;

import jakarta.validation.Valid;



@Controller
public class Expenses {
	
	private final ExpenseService expenseService;
	
	public Expenses ( ExpenseService expenseService ) {
		
		this.expenseService = expenseService;				
		
	}

	@GetMapping("/")
	public String rootRedirect () {
		
		return "redirect:/expenses";
		
	}
	
	@GetMapping("/expenses")
	public String home ( Model model ) {
		
		model.addAttribute( "allExpenses", this.expenseService.readAll() );
		
		return "expenses.jsp";
		
	}
	
	@GetMapping("/new")
	public String newExpensePage (@Valid @ModelAttribute("expense") Expense expense, BindingResult bindingResult) {
		
		return "new.jsp";
		
	}
	
	@PostMapping("/new")
	public String newExpense (@Valid @ModelAttribute("expense") Expense expense, BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {
			
			return "new.jsp";
			
		}
		
		this.expenseService.create(expense);
		
		return "redirect:/";
		
	}
	
	@GetMapping("/{id}")
	public String show ( @PathVariable("id") Long id, Model model ) {
		
		model.addAttribute("expense", this.expenseService.readOne(id));
		
		return "show.jsp";
		
	}
	
	@GetMapping("/edit/{id}")
	public String editPage ( Model model, @PathVariable("id") Long id ) {
		
		model.addAttribute("expense", this.expenseService.readOne(id));
		
		return "edit.jsp";
		
	}
	
	@PatchMapping("/edit/{id}")
	public String edit (@PathVariable("id") Long id, @Valid @ModelAttribute("expense") Expense expense, BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {
			
			return "edit.jsp";
			
		}
		
		this.expenseService.update(expense);
		
		return "redirect:/{id}";
		
	}
	
	@DeleteMapping("/{id}")
	public String delete ( @PathVariable("id") Long id ) {
		
		this.expenseService.delete(id);
		
		return "redirect:/";
		
	}
 	
}