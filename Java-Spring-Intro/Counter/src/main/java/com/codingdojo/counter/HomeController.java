package com.codingdojo.counter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
	
	public int count = 0;

	@RequestMapping("/")
	String home () {
		
		return "home.jsp";
		
	}
	
	@RequestMapping("/counter")
	String counter ( HttpSession session ) {
		
		this.count ++;
		
		session.setAttribute( "count",  this.count );
		
		return "counter.jsp";
		
	}
	
	@RequestMapping("/double-counter")
	String doubleCounter ( HttpSession session ) {
		
		this.count += 2;
		
		session.setAttribute( "count",  this.count );
		
		return "counter.jsp";
		
	}
	
	@RequestMapping("/reset-counter")
	String resetCounter ( HttpSession session ) {
		
		this.count = 0;
		
		session.setAttribute( "count", this.count );
		
		return "counter.jsp";
		
	}
	
}