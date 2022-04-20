package com.qa.baespring.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.baespring.domain.User;
import com.qa.baespring.service.UserService;

@RestController
public class UserController {
	
	private UserService service;
	
	public UserController(UserService service) {
		this.service = service;
	}

	// GET
	
	// GetAll (get all Users)
	@GetMapping("/getAll") //localhost:8080/getAll
	public List<User> getAll() {
		return service.getAll();
	}

	// Get by ID (get one User)
	@GetMapping("/getById/{id}") //localhost:8080/getById/id
	public User getById(@PathVariable long id) {
		return service.getById(id);
	}
	
	// POST
	@PostMapping("/create") // localhost:8080/create
	public User create(@RequestBody User user) {
		return service.create(user);
	}
	
	// PUT
	@PutMapping("/update/{id}") // localhost:8080/update/id
	public User update(@PathVariable long id, @RequestBody User user) {
		return service.update(id, user);
	}
	
	// DELETE
	@DeleteMapping("/delete/{id}") // localhost:8080/delete/id
	public boolean delete(@PathVariable long id) {
		return service.delete(id);
	}
}
