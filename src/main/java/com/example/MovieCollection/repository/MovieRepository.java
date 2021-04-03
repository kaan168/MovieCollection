package com.example.MovieCollection.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.MovieCollection.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long>{

	
	List<Movie> findByName(String name);
	
	

	List<Movie> findByTypeOfMovie(String type);
	
	Optional<Movie> findById(Long id);
	
	@Query(value = "SELECT * FROM MOVIE ORDER BY PUBLISHED_YEAR",nativeQuery = true)
	List<Movie> sortByYear();
}
