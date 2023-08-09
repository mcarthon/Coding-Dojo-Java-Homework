package com.codingdojo.books.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codingdojo.books.models.Book;
import com.codingdojo.books.services.BookService;

@RestController
@RequestMapping("/api")
public class Books {
	
    private final BookService bookService;
    
    public Books(BookService bookService){
    	
        this.bookService = bookService;
        
    }
    
    @PostMapping("/books")
    public Book createBook(
    		
    		@RequestParam( "title" ) String title,
    		@RequestParam( "description" ) String description,
    		@RequestParam( "language" ) String language,
    		@RequestParam( "numberOfPages" ) int numberOfPages
    		
    		) {
    	
    	Book book = new Book( title, description, language, numberOfPages );    
    	
    	return bookService.createBook( book );
    	
    }
    
    @GetMapping("/books")
    public List<Book> getAll() {
    	
    	return bookService.allBooks();
    	
    }
    
    @GetMapping("/books/{id}")
    public Book getOne(
    		
    		@PathVariable("id") Long id
    		
    		) {
    	
    	return bookService.findBook(id);
    	
    }
    
    
    
    // other methods removed for brevity
    @PatchMapping("/books/{id}")
    public Book update(
    		
    		@PathVariable("id") Long id, 

    		@RequestParam(value="title") String title, 
    		@RequestParam(value="description") String description, 
    		@RequestParam(value="language") String language,
    		@RequestParam(value="numberOfPages") Integer numberOfPages) {
    	
        Book book = bookService.updateBook(id, title, description, language, numberOfPages);
        
        return book;
        
    }
        
    @DeleteMapping(value="/books/{id}")
    public void destroy(@PathVariable("id") Long id) {
    	
        bookService.deleteBook(id);
        
    }
}