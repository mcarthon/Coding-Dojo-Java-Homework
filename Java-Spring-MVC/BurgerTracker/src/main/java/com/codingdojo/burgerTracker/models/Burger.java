package com.codingdojo.burgerTracker.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "burgers")
public class Burger {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@NotNull(message = "Burger Name must not be blank. ")
    @Size(min = 1, max = 20, message = "Burger Name must be between 1 and 20 characters. ")
    private String burgerName;
	
	@NotNull(message = "Restaurant Name must no be blank. ")
    @Size(min = 1, max = 30, message = "Restaurant Name must be between 1 and 30 characters. ")
    private String restaurantName;
	
	@NotNull(message = "Rating must not be blank. ")
    @Min(value = 0, message = "Rating must be at least 0. ")
	@Max(value = 5, message = "Rating must be no more than 5. ")
    private int rating;
	
	@NotNull(message = "Notes must not be blank. ")
	@Size(min = 1, max = 100, message = "Notes must be between 1 and 100 characters. ")
	private String notes;
	
	@Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
	
	public Burger () {}
	
	public Burger ( String burgerName, String restaurantName, int rating, String notes ) {
		
		this.burgerName = burgerName;
		
		this.restaurantName = restaurantName;
		
		this.rating  = rating;
		
		this.notes = notes;
		
	}
	
	public Burger ( Long id, String burgerName, String restaurantName, int rating, String notes ) {
		
		this.id = id;
		
		this.burgerName = burgerName;
		
		this.restaurantName = restaurantName;
		
		this.rating  = rating;
		
		this.notes = notes;
		
	}
	
	@PrePersist
    protected void onCreate(){
    	
        this.createdAt = new Date();
        
    }

	public String getBurgerName() {
		return burgerName;
	}

	public void setBurgerName(String burgerName) {
		this.burgerName = burgerName;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Long getId() {
		return id;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}
	
}