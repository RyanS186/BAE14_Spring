package com.qa.baespring.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.baespring.domain.User;
import com.qa.baespring.service.UserService;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
	
	// Link to Service
	private UserService service;
	
	public UserController(UserService service) {
		this.service = service;
	}

	// GET
	
	// GetAll (get all Users)
	@GetMapping("/getAll") //localhost:8080/user/getAll
	public ResponseEntity<List<User>> getAll() {
		return new ResponseEntity<List<User>>(service.getAll(), HttpStatus.OK);
	}

	// Get by ID (get one User)
	@GetMapping("/getById/{id}") //localhost:8080/user/getById/id
	public ResponseEntity<User> getById(@PathVariable long id) {
		return new ResponseEntity<User>(service.getById(id), HttpStatus.OK);
		
// Exception handling example
//		try {
//			return new ResponseEntity<User>(service.getById(id), HttpStatus.OK);
//		} catch (UserNotFoundException e) {
//			System.out.println(e.getMessage());
//			return null;
//		}
	}
	
	// Get by Username (get one User)
	@GetMapping("/getByUsername/{username}") //localhost:8080/user/getByUsername/
	public ResponseEntity<User> getByUsername(@PathVariable String username) {
		return new ResponseEntity<User>(service.getByUsername(username), HttpStatus.OK);
	}
	
	// Get by Gmail (get all users with a gmail address)
	@GetMapping("/getByGmail") //localhost:8080/user/getByGmail
	public ResponseEntity<List<User>> getByGmail() {
		return new ResponseEntity<List<User>>(service.getByGmail(), HttpStatus.OK);
	}
	
	// Get adults (get all users 18+)
	@GetMapping("/getAdults") //localhost:8080/user/getAdults
	public ResponseEntity<List<User>> getAdults() {
		return new ResponseEntity<List<User>>(service.getAdults(), HttpStatus.OK);
	}
	
	// Get children (get all users <18)
	@GetMapping("/getChildren") //localhost:8080/user/getChildren
	public ResponseEntity<List<User>> getChildren() {
		return new ResponseEntity<List<User>>(service.getChildren(), HttpStatus.OK);
	}
	
	// POST
	@PostMapping("/create") // localhost:8080/user/create
	public ResponseEntity<User> create(@RequestBody User user) {
		return new ResponseEntity<User>(service.create(user), HttpStatus.CREATED);
	}
	
	// PUT
	@PutMapping("/update/{id}") // localhost:8080/user/update/id
	public ResponseEntity<User> update(@PathVariable long id, @RequestBody User user) {
		return new ResponseEntity<User>(service.update(id, user),HttpStatus.OK);
	}
	
	// DELETE
	@DeleteMapping("/delete/{id}") // localhost:8080/user/delete/id
	public ResponseEntity<?> delete(@PathVariable long id) {
		return (service.delete(id))?new ResponseEntity<>(HttpStatus.NO_CONTENT):new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
