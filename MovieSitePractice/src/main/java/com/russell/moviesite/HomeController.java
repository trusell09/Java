package com.russell.moviesite;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	
	@RequestMapping("/")
	public String hello(Model model) {
		// importing Model class and creating an instance of it
		//Model model = new Model()
		
				
		String movieTitle = "Crank";
		String releaseDate = "2006-08-04";
		String imageUrl = "https://www.orlandosentinel.com/resizer/h35zeybGigJOa8HntqFeHAGW6yU=/1200x0/top/arc-anglerfish-arc2-prod-tronc.s3.amazonaws.com/public/7YEJYCFV6NEIXJHFYFN4V2E4V4.jpg";
		
		
		
		model.addAttribute("movie", movieTitle);
		model.addAttribute("rd", releaseDate);
		model.addAttribute("imageUrl", imageUrl);
		
		
		
		//array of actors 
		ArrayList<Actor> castOfActors =  new ArrayList<Actor>();
		
		castOfActors.add(new Actor("Jason", "Statham", 50));
		castOfActors.add(new Actor("Amy", "Smart", 40));
		castOfActors.add(new Actor("Jose", "Cantillo", 45));
		castOfActors.add(new Actor("Efren", "Ramirez", 45));
		castOfActors.add(new Actor("Dwight", "Yoakam", 65));
		
		
		model.addAttribute("actors", castOfActors);
		
		
		
		
		
		return "index.jsp";
	
	
		// In Python Syntax Below
		//return render_template("index.html", movie = movieTitle
	}
	
}
