package com.jwtexample.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.jwtexample.model.User;

@Service
public class UserService {
	
	public List<User>  store = new ArrayList<>();
	
	public UserService() {
		store.add(new User(UUID.randomUUID().toString(),"Jagdish","jagdish.khetre@gmail.com"));
		store.add(new User(UUID.randomUUID().toString(),"Ram","ram@gmail.com"));
		store.add(new User(UUID.randomUUID().toString(),"Satish","satish@gmail.com"));
		store.add(new User(UUID.randomUUID().toString(),"Sri","sri@gmail.com"));
	}
	
	public List<User> getUsers(){
		return this.store;
	}
}
