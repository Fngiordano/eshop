package com.example.demo.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.User;
import com.example.demo.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	private UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	// Build create User REST API
	@PostMapping
	public ResponseEntity<User> saveUser(@RequestBody User user){
		return new ResponseEntity<User>(userService.saveUser(user), HttpStatus.CREATED);
	}
	
	// Get all User
	@GetMapping
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
		
	//Get User by id - localhost:8080/api/User/#id
	@GetMapping("{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") long userId){
		return new ResponseEntity<User>(userService.getUserById(userId), HttpStatus.OK);
	}
	
	//Update User
	@PutMapping("{id}")
	public ResponseEntity<User> updateUser(@PathVariable("id") long id ,@RequestBody User user){
		return new ResponseEntity<User>(userService.updateUser(user ,id), HttpStatus.OK);
	}
	
	// Delete User
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id") long itemId){
		
		// delete User
		userService.deleteUser(itemId);
		
		return new ResponseEntity<String>("User delete successfully!.", HttpStatus.OK);
	}
	
}
