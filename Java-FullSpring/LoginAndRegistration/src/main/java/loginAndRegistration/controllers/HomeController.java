package loginAndRegistration.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import loginAndRegistration.models.LoginUser;
import loginAndRegistration.models.User;
import loginAndRegistration.services.UserService;

@Controller
public class HomeController {
 
	private final UserService userService;
 
	public HomeController ( UserService userService ) {
		
		this.userService = userService;
		
	}
 
	@GetMapping ( "/" )
	public String home( Model model ) {
 
		model.addAttribute("userRegister", new User());
		
		model.addAttribute("userLogin", new LoginUser());
     
		return "LoginRegistration.jsp";
	}
 
	@PostMapping ( "/register" )
	public String register( @Valid @ModelAttribute( "userRegister" ) User userRegister, BindingResult bindingResult, Model model, HttpSession session ) { 
		
		User registeredUser =  this.userService.register ( userRegister, bindingResult );
     
		if( bindingResult.hasErrors() ) {
			
			model.addAttribute ( "userLogin", new LoginUser() );
    	 
			return "LoginRegistration.jsp";
         
		}
		
		session.setAttribute ( "id", registeredUser.getId () );
		
     return "redirect:/" + registeredUser.getId ();
     
	}
 
	@PostMapping ( "/login" )
	public String login( @Valid @ModelAttribute( "userLogin" ) LoginUser userLogin, BindingResult bindingResult, Model model, HttpSession session ) {
 
		User loggedInUser = this.userService.login ( userLogin, bindingResult );
		
		if( bindingResult.hasErrors() ) {
			
			model.addAttribute ( "userRegister", new User () );
    	 
			return "LoginRegistration.jsp";
         
		}
		
		session.setAttribute ( "id", loggedInUser.getId () );
 
		return "redirect:/" + loggedInUser.getId();
     
	}
	
	@GetMapping ( "/{id}" )
	public String showDashboard ( @PathVariable ( "id" ) Long id, Model model, HttpSession session ) {
		
		if ( session.getAttribute ( "id" ) != null ) {
			
			model.addAttribute ( "user", this.userService.getUserById ( id ) );
			
			return "dashboard.jsp";
			
		}
		
		return "redirect:/";
		
	}
	
	@GetMapping ( "/logout" )
	public String logout ( HttpSession session ) {
		
		session.invalidate();
		
		return "redirect:/";
		
	}
 
 
}
