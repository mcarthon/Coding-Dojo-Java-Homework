package com.codingdojo.helloworld;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@RequestMapping("/")
	String index() {
		
		return "Hello World";
		
	}
	
	@RequestMapping("/world")
	String world() {
		
		return "Class annotations are cool too";
		
	}

}
