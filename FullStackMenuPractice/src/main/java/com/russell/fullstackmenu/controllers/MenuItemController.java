package com.russell.fullstackmenu.controllers;

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

import com.russell.fullstackmenu.models.MenuItem;
import com.russell.fullstackmenu.services.MenuItemService;

@Controller
public class MenuItemController {
	private final MenuItemService menuService;
	
	
	//constructor 
	public MenuItemController(MenuItemService menuService) {
		this.menuService = menuService;
	}
	
	
	// get all menu items to render on the page 
	@RequestMapping("/menuitems")
	public String index(Model model){
		System.out.println(this.menuService.allMenuItems());
		
		List<MenuItem> allMenuItems = this.menuService.allMenuItems();
		
		model.addAttribute("allMenuItems", allMenuItems);
		
		
		//send an empty MenuItem object to the form for the form to bind to
		model.addAttribute("menuItem", new MenuItem());
		//return this.menuService.allMenuItems();

		return "index.jsp";
	}
	
	
	// get information about one menu item by ID
	@RequestMapping("/menuitems/{id}")
	public String show(@PathVariable("id")Long id, Model model) {
		//retrieve menu item and put in variable
		MenuItem menuItemToShow = this.menuService.findMenuItem(id);
		
		model.addAttribute("menuItemToShow", menuItemToShow);
		
		return "oneitem.jsp";
		
	}

	
	//create a menu item(post submission of the form)
	@PostMapping("/menuitem/create")
	public String create(@Valid @ModelAttribute("menuItem") MenuItem menuItem, BindingResult result, Model model) {
		if(result.hasErrors()) {
			//need to pass in all menu items again
			List<MenuItem> allMenuItems = this.menuService.allMenuItems();
			
			model.addAttribute("allMenuItems", allMenuItems);
			
			return"index.jsp";
		}else {
			this.menuService.createMenuItem(menuItem);
			return"redirect:/menuitems";
		}
	}
	
	@RequestMapping("/menuitems/edit/{id}")
	public String edit(@PathVariable("id")Long id, Model model) {
		// get info about the menu item I want to edit so I can pre-populate the edit form with this menu items information
		
		MenuItem itemToEdit = this.menuService.findMenuItem(id);
		
		model.addAttribute("itemToEdit", itemToEdit);
		
		return"edit.jsp";
	}
	
	@PutMapping("/menuitems/update/{id}")
	public String update(@PathVariable("id")Long id, @Valid @ModelAttribute("itemToEdit")MenuItem itemToEdit , BindingResult result, Model model) {
		if (result.hasErrors()) {

			return "edit.jsp";
			}else {
				this.menuService.updateItem(itemToEdit);
				return "redirect:/menuitems";
			}
		//Prints to Console. Good way to check if things are running properly
		//System.out.println(itemToEdit.getId());
		//System.out.println(itemToEdit.getName());
	
	}
	
	
	@RequestMapping("/menuitems/delete/{id}")
	public String delete(@PathVariable("id")Long id) {
		this.menuService.deleteItem(id);
		 
		return"redirect:/menuitems";
		
	} 
	
}
	
