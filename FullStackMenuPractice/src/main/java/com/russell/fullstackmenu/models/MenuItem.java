package com.russell.fullstackmenu.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

//ABOVE IMPORTS, MATCH THEM TO SPECIFIC IMPORT EACH TIME




//Validations
@Entity
@Table(name="menuitems")
public class MenuItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	//name
	@NotNull
	@Size(min = 2, max = 30, message="Menu item name must be between 2-30 characters")
	private String name;
	
	//dishType(appetizer, drink, main dish, etc;)
	@NotNull
	@Size(min = 2, max = 30, message="Dish type must be between 2-30 characters")
	private String dishType;
		
	//price
	@NotNull
	@Min(value=1, message="Price must be at least 1 dollar")
	private double price;
	
	
	//description
	@NotNull
	@Size(min = 2, max=3000, message="Menu item description must be between 2-30 characters")
	private String description;

	
	// This will not allow the createdAt column to be updated after creation
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	
	//model.addAttribute("menuitem", new MenuItem()); below empty constructor relates to syntax on left in MenuItemController
	//empty constructor 
	public MenuItem() {
		
	}


	// loaded constructor (Source: Generate Constructors using fields, don't load id, created at and updated at)
	public MenuItem(
			String name,
			String dishType,
			double price,
			String description) {
		this.name = name;
		this.dishType = dishType;
		this.price = price;
		this.description = description;
	}
	
	//other getters and setters removed for brevity 
	@PrePersist
	protected void onCreate() {
		this.createdAt =  new Date();
	}
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}

	
	// GETTERS AND SETTERS!! REMEMBER TO HAVE THIS OR THINGS WILL NOT WORK IN THE TEMPLATES LATER
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDishType() {
		return dishType;
	}


	public void setDishType(String dishType) {
		this.dishType = dishType;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
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
	

	
	
	
	
	
	
}
