package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.UserService;


@Service
public class UserServiceImpl implements UserService {

private UserRepository userRepository;
	
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	
	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}


	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}


	@Override
	public User getUserById(long id) {

		return userRepository.findById(id).orElseThrow(() -> 
						new ResourceNotFoundException("User","Id", id));
	}


	@Override
	public User updateUser(User user, long id) {
		
		// checking if User exist
		User existingUser = userRepository.findById(id).orElseThrow(() -> 
							new ResourceNotFoundException("User","Id",id));
		
		existingUser.setFirstName(user.getFirstName());
		existingUser.setLastName(user.getLastName());
		existingUser.setEmail(user.getEmail());
		// save updated User to DB
		userRepository.save(existingUser);
		return existingUser;
	}

	@Override
	public void deleteUser(long id) {
		// checking if User exist
		userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User","Id",id));
		
		userRepository.deleteById(id);
	}

}
