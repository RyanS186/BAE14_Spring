package com.qa.baespring.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<List<User>> getAll() {
		return new ResponseEntity<List<User>>(service.getAll(), HttpStatus.OK);
	}

	// Get by ID (get one User)
	@GetMapping("/getById/{id}") //localhost:8080/getById/id
	public ResponseEntity<User> getById(@PathVariable long id) {
		return new ResponseEntity<User>(service.getById(id), HttpStatus.OK);
	}
	
	// POST
	@PostMapping("/create") // localhost:8080/create
	public ResponseEntity<User> create(@RequestBody User user) {
		return new ResponseEntity<User>(service.create(user), HttpStatus.CREATED);
	}
	
	// PUT
	@PutMapping("/update/{id}") // localhost:8080/update/id
	public ResponseEntity<User> update(@PathVariable long id, @RequestBody User user) {
		return new ResponseEntity<User>(service.update(id, user),HttpStatus.OK);
	}
	
	// DELETE
	@DeleteMapping("/delete/{id}") // localhost:8080/delete/id
	public ResponseEntity<Boolean> delete(@PathVariable long id) {
		return (service.delete(id))? new ResponseEntity<Boolean>(HttpStatus.NO_CONTENT):new ResponseEntity<Boolean>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
