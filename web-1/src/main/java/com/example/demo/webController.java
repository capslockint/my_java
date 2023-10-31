

package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class webController {
	
	@RequestMapping(value="/")
	public String login() {
		return "login";
	}
	
	@RequestMapping(value="/signup")
	public String signup() {
		return "signup";
	}
	@RequestMapping(value="/interface")
	public String landingPage() {
		return "interface";
	}
		
}


