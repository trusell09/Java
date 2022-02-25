package com.russell.dojosninjas.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.russell.dojosninjas.models.Dojo;
import com.russell.dojosninjas.models.Ninja;
import com.russell.dojosninjas.services.AppService;

@Controller
public class HomeController {
	private final AppService appServ;
	
	public HomeController(AppService appServ) {
		this.appServ = appServ;
	}
	
	
	@RequestMapping("/")
	public String home(Model model) {
		//whenever a render form is wanted, send an empty object to the form using the view model so that the form can bind to the empty object and have validations  
	model.addAttribute("dojo", new Dojo());	
		

		return "dojoPage.jsp";
	}

	@PostMapping("/dojos/create")
	public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if(result.hasErrors()) {
			return "dojoPage.jsp";
	}else {
		// if no form errors, create a dojo by using the service
		this.appServ.createDojo(dojo);
		return "redirect:/";
		}
	}
	@RequestMapping("/ninja/add")
	public String addNinja(Model model) {
		//pass an empty ninja object to the form for the form to bind to and upadte its information with
		model.addAttribute("ninja", new Ninja());
		
		//pass a list of all teams to the template so that the form can show all the dojos that the ninja can be added to
		model.addAttribute("alldojos",this.appServ.getAllDojos());
		
		return"addninja.jsp";
	}


	//create a ninja when the form submits using post request
	@PostMapping("/ninjas/create")
	public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
		if(result.hasErrors()) {
			return"addninja.jsp";
		}else {
			//if no errors in form, then create a player using the service
			this.appServ.createNinja(ninja);
			return "redirect:/";
			
		}
	}
	@RequestMapping("/dojos/{id}")
	public String showOneDojo(@PathVariable("id")Long id, Model model) {
		//get one dojo using the id from the path variable by requesting it from the service
		Dojo dojoToShow = this.appServ.getOneDojo(id);
		
		model.addAttribute("dojoToShow", dojoToShow);
		
		return"onedojo.jsp";
	}
}
