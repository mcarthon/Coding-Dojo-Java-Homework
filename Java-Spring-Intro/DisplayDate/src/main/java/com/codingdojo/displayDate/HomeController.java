package com.codingdojo.displayDate;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	public SimpleDateFormat time = new SimpleDateFormat("hh:mm a");
	
	public SimpleDateFormat date = new SimpleDateFormat("EEEE, MMMM, dd, yyyy");
	
	public Date currentDate = new Date();

	@RequestMapping("/")
	String home () {
		
		return "index.jsp";
		
	}
	
	@RequestMapping("/time")
	String renderTime ( Model model ) {
		
		model.addAttribute( "time", time.format( currentDate ) );
		
		return "time.jsp";
		
	}
	
	@RequestMapping("/date")
	String renderDate ( Model model ) {
		
		model.addAttribute( "date", date.format( currentDate ) );
		
		return "date.jsp";
		
	}
}