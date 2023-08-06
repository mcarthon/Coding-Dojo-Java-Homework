package com.codingdojo.diakichi;

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
	
}