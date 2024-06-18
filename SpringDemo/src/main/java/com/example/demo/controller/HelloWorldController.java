package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/helloApp")
public class HelloWorldController {
	
	@GetMapping("/greet")
	public String greeting() {
		
		return " Hello there";
	}
	
	

}
