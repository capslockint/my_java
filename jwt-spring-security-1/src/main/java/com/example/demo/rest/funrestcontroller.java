package com.example.demo.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class funrestcontroller {
	
	@Value("${coach.name}")
    private String coachname;
	
	@Value("${team.name}")
    private String teamname;
	 
	@GetMapping("/teaminfo")
	public String getTeamInfo() {
		return "coach: " + coachname + ", teamname: " + teamname;
	}
	
	// expose "/" that return "hello world"
	@GetMapping("/")
	public String sayHello()
	{
	  return "hello world";
}
	//new end point for workout
	
	@GetMapping("/workout")
	public String getDailyWorkout()
	{
		return "run a hard 5k";
	}
	
	// new end point for fortune
	
		@GetMapping("/fortune")
		public String getDailyFortune()
		{
			return "Its your lucky day";
		}
}
