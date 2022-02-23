package com.russell.fullstackmenu.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.russell.fullstackmenu.models.MenuItem;
import com.russell.fullstackmenu.repositories.MenuItemRepository;

@Service
public class MenuItemService {
	//adding the service repository as a dependency
	private final MenuItemRepository menuRepo;
	
	// constructor that has the repository injected into it (dependency injection)
	public MenuItemService(MenuItemRepository menuRepo) {
		this.menuRepo = menuRepo;	
	}
	
	//methods that can use the repository to talk to db
	//returns all the Menu Items
	public List<MenuItem> allMenuItems(){
		return (List<MenuItem>)this.menuRepo.findAll();
	}
	
	public MenuItem createMenuItem(MenuItem menuItem) {
		return this.menuRepo.save(menuItem);
	}

	//Retrieves a MenuItem by ID
	public MenuItem findMenuItem(Long id) {
		 
		return this.menuRepo.findById(id).orElse(null);
	}
	
	//update a MenuItem given an object
	public MenuItem updateItem(MenuItem menuItem) {
		return this.menuRepo.save(menuItem);
	}	

	//delete a MenuItem by its id
	public void deleteItem(Long id) {
		this.menuRepo.deleteById(id);
	}


}
