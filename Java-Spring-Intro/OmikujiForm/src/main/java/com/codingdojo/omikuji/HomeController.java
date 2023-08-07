package com.codingdojo.omikuji;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {

	@RequestMapping("/")
	String redirectToOmikuji () {
		
		return "redirect:/omikuji";
		
	}
	
	@RequestMapping("/omikuji")
	String omikuji () {
		
		return "omikuji-form.jsp";
		
	}
	
	@PostMapping("/submit") 
	String submitForm (
			
			@RequestParam ( value = "number" ) int number,
			@RequestParam ( value = "city" ) String city,
			@RequestParam ( value = "name" ) String name,
			@RequestParam ( value = "hobby" ) String hobby,
			@RequestParam ( value = "livingTing" ) String livingTing,
			@RequestParam ( value = "quote" ) String quote,
			
			HttpSession session
			
			) {
		
		String fortune = String.format ( """
				
				In %d years, you will live in %s with %s as your
				roommate, selling %s for a living. The next time you
				see a %s, you will have good luck. Also, %s.  
				
				""",
				number,
				city,
				name,
				hobby,
				livingTing,
				quote);
		
		session.setAttribute ( "result", fortune );
		
		return "redirect:/result";
		
	}
	
	@RequestMapping("/result")
	String result () {
		
		return "result.jsp";
		
	}
	
}