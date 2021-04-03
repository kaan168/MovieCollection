package com.example.MovieCollection.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MovieCollection.entity.User;
import com.example.MovieCollection.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;

	public void save(User user) {
		
	userRepository.save(user);
	}
	
	public User uniqueUsername(String username) {
		
		return  userRepository.findByUsername(username);
	}
	
	
	public User findbyName(User user) {
		return userRepository.findByUsername(user.getUsername());
	}
	public User findbyPass(User user) {
		return userRepository.findByPassword(user.getPassword());
	}
	
	
}
