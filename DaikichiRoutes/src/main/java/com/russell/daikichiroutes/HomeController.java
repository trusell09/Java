package com.russell.daikichiroutes;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	@RequestMapping("/")
	public String hello() {
		return "Daikichi Routes!";
	}
	@RequestMapping("/daikichi")
	public String welcome() {
		return "Welcome!";
	}
	@RequestMapping("/daikichi/today")
	public String today() {
		return "Today you will find luck in all your endeavors!";
	}
	@RequestMapping("/daikichi/tomorrow")
	public String tomorrow() {
		return "Tomorrow, an opportunity will arise, so be sure to be open to new ideas!";
	}
	@RequestMapping("/daikichi/travel/{destination}")
	public String showTeam(@PathVariable("destination") String destination) {
		System.out.println(destination);
		return String.format("Congratulations! You will soon travel to %s!", destination);
	}	
	@RequestMapping("/daikichi/lotto/{numInput}")
	public String lotto(@PathVariable("numInput") int numInput){
		if(numInput % 2 == 0) {
			return "You will take a grand journey in the near future, but be weary of tempting offers.";
		}
		return "You have enjoyed the fruits of your labor but now is a great time to spend time with family and friends.";
	    }
}
