package com.codingdojo.books.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.books.models.Book;
import com.codingdojo.books.repositories.BookRepository;

@Service
public class BookService {

	// adding the book repository as a dependency
    private final BookRepository bookRepository;
    
    public BookService(BookRepository bookRepository) {
    	
        this.bookRepository = bookRepository;
        
    }
    // returns all the books
    public List<Book> allBooks() {
    	
        return bookRepository.findAll();
        
    }
    // creates a book
    public Book createBook(Book b) {
    	
        return bookRepository.save(b);
        
    }
    // retrieves a book
    public Book findBook(Long id) {
    	
        Optional<Book> optionalBook = bookRepository.findById(id);
        
        if(optionalBook.isPresent()) {
        	
            return optionalBook.get();
            
        } else {
        	
            return null;
        }
        
    }
    
    public List<Book> findByDescriptionContaining(String search) {
    	
    	return bookRepository.findByDescriptionContaining( search );
    	
    }
	public void deleteBook(Long id) {
		
		bookRepository.deleteById(id);
		
		return;
		
	}
	public Book updateBook(Long id, String title, String description, String language, Integer numberOfPages) {
		
		Book book = new Book( id, title, description, language, numberOfPages );
		
		return bookRepository.save(book);
	}
	
}