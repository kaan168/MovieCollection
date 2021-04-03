package com.example.MovieCollection.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.MovieCollection.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByUsername(String username);

	User findByDisplayname(String displayname);
	
	User findByPassword(String password);
	
	
}
