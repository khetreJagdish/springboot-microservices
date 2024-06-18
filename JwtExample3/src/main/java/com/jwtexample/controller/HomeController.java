package com.jwtexample.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwtexample.model.User;
import com.jwtexample.service.UserService;

@RestController
@RequestMapping("/home")
public class HomeController {
	
	@Autowired
	private UserService userService;
	
	// http://localhost:8081/home/user
	@GetMapping("/user")
	public List<User> getUser() {
		System.out.println("Getting Users");
		return this.userService.getUsers();
	}
	
	@GetMapping("/currentUser")
	public String currentUser(Principal principal) {
		return principal.getName();
	}
}
