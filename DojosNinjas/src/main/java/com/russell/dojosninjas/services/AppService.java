package com.russell.dojosninjas.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.russell.dojosninjas.models.Dojo;
import com.russell.dojosninjas.models.Ninja;
import com.russell.dojosninjas.repositories.DojoRepository;
import com.russell.dojosninjas.repositories.NinjaRepository;

@Service
public class AppService {
	
	private final DojoRepository dojoRepo;
	private final NinjaRepository ninjaRepo;
	
	public AppService(DojoRepository dojoRepo, NinjaRepository ninjaRepo) {

		this.dojoRepo = dojoRepo;
		this.ninjaRepo = ninjaRepo;
	}

	
	
	
	//create a dojo
	public Dojo createDojo(Dojo dj) {
		return this.dojoRepo.save(dj);
	}

	//get all the dojos
	public List<Dojo> getAllDojos(){
		return (List<Dojo>) this.dojoRepo.findAll();	
	}

	//create a ninja
	public Ninja createNinja(Ninja nj) {
		return this.ninjaRepo.save(nj);
	}
	//get one team by id
	public Dojo getOneDojo(Long id) {
		return this.dojoRepo.findById(id).orElse(null);
	}

}
