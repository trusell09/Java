package com.russell.savetravels.models;

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


//Validations
@Entity
@Table(name="saveservices")
public class SaveService {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	//Expenses for traveling
	@NotNull
	@Size(min = 2, max = 30, message="Must be between 2-30 characters")
	private String expense;
	
	//vendor for travel arrangements 
	@NotNull
	@Size(min = 2, max = 30, message="Must be between 2-30 characters")
	private String vendor;
		
	//price
	@NotNull
	@Min(value=1, message="Price must be at least 1 dollar")
	private double price;
	
	
	//description
	@NotNull
	@Size(min = 2, max=3000, message="Description must be between 2-30 characters")
	private String description;

	
	// This will not allow the createdAt column to be updated after created
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	
	//model.addAttribute("saveservice", new SaveService()); below empty constructor relates to syntax on left in SaveServiceController
	//empty constructor 
	public SaveService() {
		
	}


	// loaded constructor (Source: Generate Constructors using fields, don't load id, created at and updated at)
	public SaveService(
			String expense,
			String vendor,
			double price,
			String description) {
		this.expense = expense;
		this.vendor = vendor;
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

	//GENERATE ALL GETTERS AND SETTERS (SOURCE, GENERATE GETTERS AND SETTERS, SELECT ALL)
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getExpense() {
		return expense;
	}


	public void setExpense(String expense) {
		this.expense = expense;
	}


	public String getVendor() {
		return vendor;
	}


	public void setVendor(String vendor) {
		this.vendor = vendor;
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
