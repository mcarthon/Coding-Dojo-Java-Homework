package com.codingdojo.diakichi;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/daikichi")
public class HomeController {
	
	@RequestMapping("/")
	String welcome() {
		
		return "Welcome";
		
	}

	@RequestMapping("/today")
	String today() {
		
		return "Today you will find luck in all  of your endeavors!";
		
	}
	
	@RequestMapping("/tomorrow")
	String tomorrow() {
		
		return "Tomorrow, an oppurtunity will arise, so be sure to be open to new ideas!";
		
	}
	
	@RequestMapping( "/travel/{city}" )
	String travelCity ( @PathVariable ( "city" ) String city ) {
		
		return "Congratulations! You will soon travel to " + city + "! ";
		
	}
	
	@RequestMapping( "/lotto/{number}" )
	String lottoNumber ( @PathVariable ( "number" ) int number ) {
		
		if ( number % 2 == 0 ) {
			
			return "You will take a grand journey in the near future, but be weary of tempting offers.";
			
		}
		
		return "You have enjoyed the fruits of your labor but now is a great time to spend time with family and friends.";
		
	}
	
}