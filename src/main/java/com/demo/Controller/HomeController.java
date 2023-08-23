package com.demo.Controller;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
public class HomeController {
	
	@GetMapping("/home")
	public String home() {
		
		return "This is Home Page"; 
	}
	

	@GetMapping("/login")
	public String login() {
		
		return "This is Login Page"; 
	}
	
	@GetMapping("/register")
	public String register() {
		
		return "This is Register Page"; 
	}

}
