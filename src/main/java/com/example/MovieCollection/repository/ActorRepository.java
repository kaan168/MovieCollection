package com.example.MovieCollection.repository;
import com.example.MovieCollection.entity.Actor;

import java.util.List;
import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;




public interface ActorRepository extends JpaRepository<Actor,Long> {
	
	Optional<Actor> findById(Long id);
	
	Long findByMovie(Long id);
	
	List<Actor> findByName (String name);

	List<Actor> findByMovieId(Long id);
	

}
