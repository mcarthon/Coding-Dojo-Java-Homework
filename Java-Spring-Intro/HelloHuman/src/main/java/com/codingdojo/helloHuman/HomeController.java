package com.codingdojo.helloHuman;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@RequestMapping("/")
	String greeting ( 
			
			@RequestParam ( value = "firstName", required = false ) String firstName, 
			@RequestParam ( value = "lastName", required = false ) String lastName,
			@RequestParam ( value = "times", required = false ) int times
			
			) {
		
		if ( firstName == null ) {
			
			String returnString = "Hello Human"; 
			
			return returnString.repeat( times );
			
		}
		
		String returnString = "Hello " + firstName + " " + lastName + " "; 
		
		return returnString.repeat( times );
		
	}
	
}