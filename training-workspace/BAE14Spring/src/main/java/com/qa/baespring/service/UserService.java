package com.qa.baespring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.baespring.domain.User;
import com.qa.baespring.exceptions.UserNotFoundException;
import com.qa.baespring.repo.UserRepo;

@Service
public class UserService {

	// Link to repo
	private UserRepo repo;

	public UserService(UserRepo repo) {
		this.repo = repo;
	}
	
	// Get ALL users
	public List<User> getAll() {
		return repo.findAll();
	}
	
	// Get by ID (get one user)
	// This could also have: throws UserNotFoundException in the signature, to throw this exception up to controller
	public User getById(long id) {
//		return repo.findById(id).get(); // .get() will either get the user (if exists) or throw NoSuchElementException 
//		return repo.findById(id).orElseThrow(() -> new UserNotFoundException(id));
		return repo.findById(id).orElseThrow(UserNotFoundException::new);

// Exception handling example for handling the exception here
//		try {
//			return repo.findById(id).orElseThrow(UserNotFoundException::new);
//		} catch (UserNotFoundException e) {
//			System.out.println(e.getMessage());
//			return null;
//		}
	}
	
	// Get by Username (get one user)
	public User getByUsername(String username) {
		return repo.findByUsername(username).get();
	}
	
	// Get by gmail (get users with gmail addresses)
	public List<User> getByGmail() {
		return repo.findByGmail();
	}
	
	// Get adults (get anyone aged 18+)
	public List<User> getAdults() {
		return repo.findAdults();
	}
	
	// Get children (get anyone aged under 18)
	public List<User> getChildren() {
		return repo.findChildren();
	}
	
	// Create a new user
	public User create(User user) {
		return repo.saveAndFlush(user);
	}
	
	// Update a user
	public User update(long id, User user) {
		User existing = repo.findById(id).orElseThrow(UserNotFoundException::new); // GET the existing user
		existing.setFirstName(user.getFirstName()); // Change existing user's firstName to new user's firstName
		existing.setLastName(user.getLastName()); // Change existing user's lastName to new user's lastName
		existing.setAge(user.getAge());
		existing.setUsername(user.getUsername()); // Change existing user's username to new user's username
		existing.setEmailAddress(user.getEmailAddress());
		return repo.saveAndFlush(existing);
	}
	
	// Delete a user
	public boolean delete(long id) {
		repo.deleteById(id); // 
		return !repo.existsById(id); // Due to the !, this method will return true if the delete is successful
	}
}
