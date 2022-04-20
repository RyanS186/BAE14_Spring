package com.qa.baespring.service;

import org.springframework.stereotype.Service;

import com.qa.baespring.domain.User;
import com.qa.baespring.repo.UserRepo;

@Service
public class UserService {

	private UserRepo repo;

	public UserService(UserRepo repo) {
		this.repo = repo;
	}
	
	// Get by ID (get one User)
	public User getById(long id) {
		return repo.findById(id).get(); // .get() will either get the user (if exists) or throw NoSuchElementException 
	}
	
}
