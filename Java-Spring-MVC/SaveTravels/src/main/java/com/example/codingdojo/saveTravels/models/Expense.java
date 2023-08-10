package com.example.codingdojo.saveTravels.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="expenses")
public class Expense {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@NotBlank(message = "Name of Expense must not be blank. ")
	@Size(min = 1, max = 20, message = "Expense name must be between 1 and 20 characters. ")
	private String expenseName;
	
	@NotBlank(message = "Vendor name must not be blank. ")
	@Size(min = 1, max = 30, message = "Vendor name must be between 1 and 30 characters. ")
	private String vendor;

	@NotNull(message = "amount must not be null. ")
	@Min(value = 0, message = "Amount must not be less than $0.00. ")
	private double amount;
	
	@NotBlank(message = "Description must not be blank. ")
	private String description;
	
	@Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    public Expense () {}
    
    public Expense ( String expenseName, String vendor, double amount, String description ) {
    	
    	this.expenseName = expenseName;
    
    	this.vendor = vendor;
    	
    	this.amount = amount;
    	
    	this.description = description;
    	
    }
    
    @PrePersist
    protected void onCreate(){
    	
        this.createdAt = new Date();
        
    }
	
	 public void setId(Long id) {
		this.id = id;
	}

	@PreUpdate
	    protected void onUpdate(){
	        this.updatedAt = new Date();
	    }

	public String getExpenseName() {
		return expenseName;
	}

	public void setExpenseName(String expenseName) {
		this.expenseName = expenseName;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Long getId() {
		return id;
	}
	
}