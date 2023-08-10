package com.example.codingdojo.saveTravels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.codingdojo.saveTravels.models.Expense;
import com.example.codingdojo.saveTravels.repositories.ExpenseRepository;

@RestController
@RequestMapping("/api")
public class ExpenseService {
	
	private final ExpenseRepository expenseRepository;
	
	public ExpenseService ( ExpenseRepository expenseRepository ) {
		
		this.expenseRepository = expenseRepository;
		
	}
	
	public Expense create ( Expense expense ) {
		
		return this.expenseRepository.save( expense );
		
	}
	
	public List<Expense> readAll () {
		
		return this.expenseRepository.findAll();
		
	}
	
	public Expense readOne ( Long id ) {
		
		Optional<Expense> optionalExpense = this.expenseRepository.findById(id);
		
		if ( optionalExpense.isPresent() ) {
			
			return optionalExpense.get();
			
		}
		
		return null;
		
	}
	
	public Expense update ( Expense expense ) {
		
		return this.expenseRepository.save( expense );
		
	}
	
	public void delete ( Long id ) {
		
		this.expenseRepository.deleteById(id);
		
	}

}