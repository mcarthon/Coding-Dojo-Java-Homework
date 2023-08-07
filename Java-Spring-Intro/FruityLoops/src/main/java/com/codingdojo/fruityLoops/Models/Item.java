package com.codingdojo.fruityLoops.Models;

public class Item {
	
	private String name;
	
	private double price;
	
	public Item ( String name, double price ) {
		
		this.name = name;
		
		this.price = price;
		
	}
	
	public String getName () {
		
		return this.name;
		
	}
	
	public double getPrice () {
		
		return this.price;
		
	}
	
	public Item setName ( String newName ) {
		
		this.name = newName;
		
		return this;
		
	}
	
	public Item setPrice ( double newPrice ) {
		
		this.price = newPrice;
		
		return this;
		
	}

}