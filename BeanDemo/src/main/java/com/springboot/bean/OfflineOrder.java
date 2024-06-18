package com.springboot.bean;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class OfflineOrder implements Order {

	
	public OfflineOrder() {
		System.out.println("From Offline Order");
	}
	
	@Override
	public void getOrder() {
		// TODO Auto-generated method stub
	}

}
