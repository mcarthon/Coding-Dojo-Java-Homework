package com.example.codingdojo.dojoAndNinjas.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table( name = "ninjas" )
public class Ninja {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // generates an auto incrementing 
	private Long id;
	
	@NotBlank(message = "First name must not be blank. ")
	@Size(min = 1, max = 20, message = "First name must be between 1 and 20 characters. ")
	private String firstName;
	
	@NotBlank(message = "Last name must not be blank. ")
	@Size(min = 1, max = 30, message = "Last name must be between 1 and 30 characters. ")
	private String lastName;

	@NotNull(message = "Age must not be null. ")
	@Min(value = 0, message = "Age must not be less than 0. ")
	private int age;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "dojo_id")
	private Dojo dojo_id;
	
	@Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
	
	@PrePersist // adds the created at date and time to sql on creation 
	protected void onCreate() {
		this.createdAt = new Date();
	}

	@PreUpdate // add the updated at date and time when being updated
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
	
	public Ninja () {}

	public Ninja ( String firstName, String lastName, int age, Dojo dojo_id ) {
		
		this.firstName = firstName;
		
		this.lastName = lastName;
		
		this.age = age;
		
		this.dojo_id = dojo_id;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Dojo getDojo_id() {
		return dojo_id;
	}

	public void setDojo_id(Dojo dojo_id) {
		this.dojo_id = dojo_id;
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
	
}
































