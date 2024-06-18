package com.springboot.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Invoice {
	
	@Autowired
	Order order;
	
	public Invoice() {
		System.out.println("Initialize Invoice");
	}
}
