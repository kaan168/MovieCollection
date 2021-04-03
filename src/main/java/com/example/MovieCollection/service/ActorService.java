package com.example.MovieCollection.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MovieCollection.entity.Actor;
import com.example.MovieCollection.repository.ActorRepository;

@Service
public class ActorService {
	
	@Autowired
	ActorRepository actorRepository;

	public void save(Actor actor) {
		
		actorRepository.save(actor);
		
	}
	public Optional<Actor> findById(Long id) {
		 return actorRepository.findById(id);
	}
	
	public List<Actor> queryByName(String name) {
		return (List<Actor>) actorRepository.findByName(name);
	}
	
	public List<Actor> queryById(Long id){
		return actorRepository.findByMovieId(id);
	}
	public void delete(Long id) {
		
		 actorRepository.deleteById(id);
	}
	
	public Actor getOne(Long id) {
		return actorRepository.getOne(id);
	}
}
