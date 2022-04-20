package com.qa.baespring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.baespring.domain.User;
import com.qa.baespring.repo.UserRepo;

@Service
public class UserService {

	private UserRepo repo;

	public UserService(UserRepo repo) {
		this.repo = repo;
	}
	
	// Get by ID (get one user)
	public User getById(long id) {
		return repo.findById(id).get(); // .get() will either get the user (if exists) or throw NoSuchElementException 
	}
	
	// Get ALL users
	public List<User> getAll() {
		return repo.findAll();
	}
	
	// Create a new user
	public User create(User user) {
		return repo.saveAndFlush(user);
	}
}
