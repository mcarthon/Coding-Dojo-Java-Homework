package BookClub.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import BookClub.models.Book;
import BookClub.services.BookService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class BookController {

	private final BookService bookService;
	
	public BookController ( BookService bookService ) {
		
		this.bookService = bookService;
		
	}
	
	@GetMapping("/books")
	public String allBooks ( Model model, HttpSession session ) {
		
		if ( session.getAttribute ( "user_id" ) != null ) {
			
			model.addAttribute ( "allBooks", this.bookService.findAllBooks () );
			
			return "dashboard.jsp";			
			
		}
		
		return "redirect:/";
		
	}
	
	@GetMapping("/books/new")
	public String newBookPage ( @ModelAttribute ( "newBook" ) Book newBook, HttpSession session ) {
		
		if ( session.getAttribute ( "user_id" ) != null ) {
			
			return "newBookPage.jsp";
				
		}

		return "redirect:/";
		
	}
	
	@PostMapping("/books") 
	public String addNewBook ( Book book, @Valid @ModelAttribute ( "newBook" ) Book newBook, BindingResult bindingResult, Model model ) {
		
		if ( bindingResult.hasErrors () ) {
			
			return "newBookPage.jsp";
			
		}
		
		this.bookService.addBook ( newBook );
		
		return "redirect:/books";
		
	}
	
	@GetMapping("/books/{id}")
 	public String showBook ( @PathVariable ( "id" ) Long id, Model model, HttpSession session ) {
		
		if ( session.getAttribute ( "user_id" ) != null ) {
			
			model.addAttribute ( "book", this.bookService.findBook ( id ) );
			
			return"showBook.jsp";			
			
		}
		
		return "redirect:/";		
	}
	
	@GetMapping("/books/edit/{id}")
	public String showEditPage ( @PathVariable ( "id" ) Long id, Model model, HttpSession session, @ModelAttribute ( "book" ) Book book ) {
		
		if ( session.getAttribute ( "user_id" ) != null ) {
			
			model.addAttribute ( "book", this.bookService.findBook ( id ) );
			
			return "editPage.jsp";
						
		}
		
		return "redirect:/";
		
	}
	
	@PatchMapping("/books/edit/{id}")
	public String editBook ( @PathVariable ( "id" ) Long id, @Valid @ModelAttribute ( "book" ) Book book, BindingResult bindingResult, Model model ) {
		
		if ( bindingResult.hasErrors () ) {
			
//			System.out.println ( bindingResult.getFieldErrors ().get (1).getDefaultMessage() );
//			
//			System.out.println ( bindingResult.getFieldErrors ( ).size () );
			
			String errors = "";
			
			for (  int i = 0; i < bindingResult.getFieldErrors ( ).size (); ++ i ) {
				
				errors += bindingResult.getFieldErrors ( ).get (i).getDefaultMessage () + "\n";
				
			}
			
			model.addAttribute ( "book", this.bookService.findBook ( id ) );
			
			model.addAttribute ( "errors", errors );
			
			return "editPage.jsp";
			
		}
		
		this.bookService.updateBook ( book );
		
		return "redirect:/books{id}";
		
	}
	
	@DeleteMapping("/books/{id}")
	public String deleteBook ( @PathVariable ( "id" ) Long id ) {
		
		this.bookService.deleteBook ( id );
		
		return "redirect:/books";
		
	}
	
}









































