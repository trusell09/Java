package com.russell.savetravels.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.russell.savetravels.models.SaveService;
import com.russell.savetravels.services.SaveServiceService;

@RestController
public class SaveTravelAPI {

	private final SaveServiceService saveService;
	
	public SaveTravelAPI(SaveServiceService saveService) {
		this.saveService = saveService;
	}
	
	@RequestMapping("/api/savetravels")
	public List<SaveService> index(){
		
		return this.saveService.allSaveServices();
	}

	
	@PostMapping("/api/savetravels")
	public SaveService create(
			@RequestParam("expense") String expense,
			@RequestParam("vendor") String vendor,
			@RequestParam("price") double price,
			@RequestParam("description") String description
			){
		// create an instance of Service with info from the form
		SaveService newItem = new SaveService(expense, vendor, price, description);
		
		return this.saveService.createSaveService(newItem);
		
	}

	@RequestMapping("/api/savetravels/{id}")
	public SaveService show(@PathVariable("id")Long id) {
		//retrieve menu item and put in variable
		SaveService saveServiceToShow = this.saveService.findSaveService(id);
		
		return saveServiceToShow;
		
	}












}
