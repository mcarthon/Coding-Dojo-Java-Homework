package com.codingdojo.ninjaGoldGame;

import java.util.Date;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {

	int goldCount = 0;
	
	int randomIncrease = 0;
	
	Random randomNumber = new Random();
	
	String log = "";
	
	@GetMapping("/")
	String home ( HttpSession session ) {
		
		session.setAttribute( "goldCount", this.goldCount );
		
		session.setAttribute( "log", this.log );
		
		if ( this.goldCount < -1 ) {
			
			return "jail.jsp";
			
		}
		
		return "home.jsp";
		
	}
	
	@PostMapping("/add-money")
	String addMoney (
			
			@RequestParam ( "location" ) String location
			
			) {
		
		switch ( location ) {
		
		case "farm":
			
			this.randomIncrease = this.randomNumber.nextInt ( 10, 21 );
			
			this.goldCount += this.randomIncrease;
			
			this.log += String.format ( "You entered a %s and earned %d gold. %s\n", location, this.randomIncrease, new Date() );
			
			break;
		
		case "cave":
				
			this.randomIncrease = this.randomNumber.nextInt ( 5, 11 );
			
			this.goldCount += this.randomIncrease;
			
			this.log += String.format ( "You entered a %s and earned %d gold. %s\n", location, this.randomIncrease, new Date() );
			
			break;
			
		case "house":
			
			this.randomIncrease = this.randomNumber.nextInt ( 2, 6 );
			
			this.goldCount += this.randomIncrease;
			
			this.log += String.format ( "You entered a %s and earned %d gold. %s\n", location, this.randomIncrease, new Date() );
			
			break;
			
		case "quest":
			
			this.randomIncrease = this.randomNumber.nextInt ( -50, 51 );
			
			this.goldCount += this.randomIncrease;
			
			this.log += String.format ( "You entered a %s and earned %d gold. %s\n", location, this.randomIncrease, new Date() );
			
			break;
			
		case "spa":
			
			this.randomIncrease = this.randomNumber.nextInt ( -20, -4 );
			
			this.goldCount += this.randomIncrease;
			
			this.log += String.format ( "You entered a %s and earned %d gold. %s\n", location, this.randomIncrease, new Date() );
			
			break;
			
		default:
			
			break;
			
		}
		
		return "redirect:/";
		
	}
	
	@GetMapping("/reset")
	String reset ( HttpSession session ) {
		
		session.invalidate();
		
		this.goldCount = 0;
		
		this.log = "";
		
		return "redirect:/";
		
	}
	
}