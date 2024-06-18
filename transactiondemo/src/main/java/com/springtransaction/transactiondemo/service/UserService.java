package com.springtransaction.transactiondemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springtransaction.transactiondemo.entity.AppUser;
import com.springtransaction.transactiondemo.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Transactional
	public AppUser createUser(AppUser user) {
		return userRepository.save(user);
	}

	@Transactional
	public AppUser updateUserEmail(Long userId, String newEmail) {
		AppUser user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
		user.setEmail(newEmail);
		return userRepository.save(user);
	}
}
