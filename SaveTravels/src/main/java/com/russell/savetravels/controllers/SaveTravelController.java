package com.russell.savetravels.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.russell.savetravels.models.SaveService;
import com.russell.savetravels.services.SaveServiceService;

@Controller
public class SaveTravelController {
	private final SaveServiceService saveService;
	
	
	//constructor 
	public SaveTravelController(SaveServiceService saveService) {
		this.saveService = saveService;
	}
	

	
	
	// get all services to render on the page 
	@RequestMapping("/savetravels")
	public String index(Model model){
		System.out.println(this.saveService.allSaveServices());

		List<SaveService> allSaveServices = this.saveService.allSaveServices();
		
		model.addAttribute("allSaveServices", allSaveServices);
		
		
		//send an empty Services object to the form for the form to bind to
		model.addAttribute("saveService", new SaveService());
		

		return "index.jsp";
	}
	
	
	// get information about one Service by ID
	@RequestMapping("/savetravels/{id}")
	public String show(@PathVariable("id")Long id, Model model) {
		//retrieve menu item and put in variable
		SaveService saveServiceToShow = this.saveService.findSaveService(id);
		
		model.addAttribute("saveServiceToShow", saveServiceToShow);
		
		return "oneitem.jsp";
		
	}

	
	//create a service(post submission of the form)
	@PostMapping("/savetravels/create")
	public String create(@Valid @ModelAttribute("saveService") SaveService saveService, BindingResult result, Model model) {
		if(result.hasErrors()) {
			//need to pass in all services again
			List<SaveService> allSaveServices = this.saveService.allSaveServices();
			
			model.addAttribute("allSaveServices", allSaveServices);
			
			return"index.jsp";
		}else {
			this.saveService.createSaveService(saveService);
			return"redirect:/savetravels";
		}
	}
	
	@RequestMapping("/savetravels/edit/{id}")
	public String edit(@PathVariable("id")Long id, Model model) {
		// get info about the menu item I want to edit so I can pre-populate the edit form with this menu items information
		
		SaveService itemToEdit = this.saveService.findSaveService(id);
		
		model.addAttribute("itemToEdit", itemToEdit);
		
		return"edit.jsp";
	}
	
	@PutMapping("/savetravels/update/{id}")
	public String update(@PathVariable("id")Long id, @Valid @ModelAttribute("itemToEdit")SaveService itemToEdit , BindingResult result, Model model) {
		if (result.hasErrors()) {

			return "edit.jsp";
			}else {
				this.saveService.updateItem(itemToEdit);
				return "redirect:/savetravels";
			}
		//Prints to Console. Good way to check if things are running properly
		//System.out.println(itemToEdit.getId());
		//System.out.println(itemToEdit.getName());
	
	}
	
	
	@RequestMapping("/savetravels/delete/{id}")
	public String delete(@PathVariable("id")Long id) {
		this.saveService.deleteItem(id);
		 
		return"redirect:/savetravels";
		
	} 






}
