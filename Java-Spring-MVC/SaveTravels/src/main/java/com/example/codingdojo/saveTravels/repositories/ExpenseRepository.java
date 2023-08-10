package com.example.codingdojo.saveTravels.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.codingdojo.saveTravels.models.Expense;



@Repository
public interface ExpenseRepository extends CrudRepository<Expense, Long> {
	
	List<Expense> findAll();

}