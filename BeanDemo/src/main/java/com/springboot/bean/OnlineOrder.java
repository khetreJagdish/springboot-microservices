package com.springboot.bean;

import org.springframework.stereotype.Component;

@Component
public class OnlineOrder implements Order {

	public OnlineOrder() {
		System.out.println("From Online Order");
	}

	@Override
	public void getOrder() {
		// TODO Auto-generated method stub
		
	}
}
