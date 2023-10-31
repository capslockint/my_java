package com.example.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Coach;



@RestController
public class DemoController {
	// private filed for dependency
	private Coach myCoach;
	
	//define a constructor for dependency injection
	@Autowired
	public DemoController(Coach theCoach)
	{
		myCoach = theCoach;
	}
	
	@GetMapping("/dailyworkout")
	public String getDailyWorkout() {
	return myCoach.getDailyWorkout();
	}
}
