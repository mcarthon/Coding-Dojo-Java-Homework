package com.codingdojo.books.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.codingdojo.books.services.BookService;

@Controller
public class BooksController {
	
	private final BookService bookService;

	public BooksController ( BookService bookService ) {
		
		this.bookService = bookService;
		
	}
	
	@GetMapping("/show/{id}")
	public String show( Model model, @PathVariable("id") Long id ) {
		
		model.addAttribute( "book", this.bookService.findBook(id) );
		
		return "show.jsp";
		
	}
	
}