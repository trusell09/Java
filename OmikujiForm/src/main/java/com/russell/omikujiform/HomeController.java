package com.russell.omikujiform;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String home() {
	return"index.jsp";
	}

	@PostMapping("/process_form")
	public String process(
			@RequestParam("pick_num") Integer pick_num,
			@RequestParam("city") String city,
			@RequestParam("real_person") String real_person,
			@RequestParam("hobby") String hobby,
			@RequestParam("living_thing") String living_thing,
			@RequestParam("fun_fact") String fun_fact,
			HttpSession session
			) {
		
		System.out.println("form submitted");
		
		session.setAttribute("pick_num", pick_num);
		session.setAttribute("city", city);
		session.setAttribute("real_person", real_person);
		session.setAttribute("hobby", hobby);
		session.setAttribute("living_thing", living_thing);
		session.setAttribute("fun_fact", fun_fact);
		
		return"redirect:/details";
	}

	@RequestMapping("/details")
	public String showDetails() {
		return"details.jsp";
	}
}
