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
	
	// Update a user
	public User update(long id, User user) {
		User existing = repo.findById(id).get(); // GET the existing user
		existing.setFirstName(user.getFirstName()); // Change existing user's firstName to new user's firstName
		existing.setLastName(user.getLastName()); // Change existing user's lastName to new user's lastName
		existing.setUsername(user.getUsername()); // Change existing user's username to new user's username
		return repo.saveAndFlush(existing);
	}
}
