package com.example.MovieCollection.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.MovieCollection.entity.Movie;
import com.example.MovieCollection.repository.MovieRepository;

@Service
public class MovieService {

	
	@Autowired
	MovieRepository movieRepository;
	
	
	
	public List<Movie> getall(){
		
		return movieRepository.findAll();
	}
	
	public void save(Movie movie) {
		
		movieRepository.save(movie);
	}
	
	public Movie getById(Long id) {
		return movieRepository.getOne(id);
	}
	
	public void delete(Movie movie) {
		movieRepository.delete(movie);
	}
	
	public List<Movie> queryByName(String name) {
		return (List<Movie>) movieRepository.findByName(name);
		
	}

	
	
	public List<Movie> queryByTypeOfMovie(String type) {
		return (List<Movie>) movieRepository.findByTypeOfMovie(type);
	}
	public Optional<Movie> queryById(Long id) {
		return (Optional<Movie>) movieRepository.findById(id);
		
	}
	public List<Movie> sortByYear(){
		return movieRepository.sortByYear();
	}
	
	
}
