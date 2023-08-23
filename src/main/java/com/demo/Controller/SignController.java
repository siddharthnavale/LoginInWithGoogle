package com.demo.Controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SignController {
	
	@GetMapping("/signin")
	public String signIn() {
		return "login.html";
	}

}
