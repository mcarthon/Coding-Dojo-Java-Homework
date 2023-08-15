package BookClub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import BookClub.models.Book;
import BookClub.repositories.BookRepository;

@Service
public class BookService {

	private final BookRepository bookRepository;
	
	public BookService ( BookRepository bookRepository ) {
		
		this.bookRepository = bookRepository;
		
	}
	
	public Book addBook ( Book book ) {
		
		return this.bookRepository.save ( book );
		
	}
	
	public List<Book> findAllBooks () {
		
		return this.bookRepository.findAll ();
		
	}
	
	public Book findBook ( Long id ) {
		
		Optional<Book> optionalBook = this.bookRepository.findById ( id );
		
		if ( optionalBook.isPresent () ) {
			
			return optionalBook.get ();
			
		}
		
		return null;
		
	}
	
	public Book updateBook ( Book book ) {
		
		return this.bookRepository.save ( book );
		
	}
	
	public void deleteBook ( Long id ) {
		
		this.bookRepository.deleteById ( id );
		
	}
	
}