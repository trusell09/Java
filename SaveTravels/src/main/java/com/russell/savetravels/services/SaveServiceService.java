package com.russell.savetravels.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.russell.savetravels.models.SaveService;
import com.russell.savetravels.repositories.SaveServiceRepository;

@Service
public class SaveServiceService {
	//adding the service repository as a dependency
		private final SaveServiceRepository saveRepo;
		
		// constructor that has the repository injected into it (dependency injection)
		public SaveServiceService(SaveServiceRepository saveRepo) {
			this.saveRepo = saveRepo;	
		}
		
		//methods that can use the repository to talk to db
		//returns all the Services
		public List<SaveService> allSaveServices(){
			return (List<SaveService>)this.saveRepo.findAll();
		}
		
		public SaveService createSaveService(SaveService SaveService) {
			return this.saveRepo.save(SaveService);
		}

		//Retrieves a Service by ID
		public SaveService findSaveService(Long id) {
			 
			return this.saveRepo.findById(id).orElse(null);
		}
		
		//update a Service given an object
		public SaveService updateItem(SaveService saveService) {
			return this.saveRepo.save(saveService);
		}	

		//delete a Service by its id
		public void deleteItem(Long id) {
			this.saveRepo.deleteById(id);
		}




}
