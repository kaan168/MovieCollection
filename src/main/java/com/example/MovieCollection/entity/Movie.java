package com.example.MovieCollection.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;



@Entity
public class Movie {
	
	
	 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	private String name;
	
	private int publishedYear;
	
	private String typeOfMovie;
	
	private String explanation;
	
	
	private String media;
	
	@ElementCollection(targetClass=String.class)
	private List<String> languages;
	
	
	
	
	@OneToMany(mappedBy = "movie",cascade = CascadeType.ALL)
	private List<Actor> actors=new ArrayList<>();

	
	



	public Long getId() {
		return id;
	}

 

	public void setId(Long id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getPublishedYear() {
		return publishedYear;
	}



	public void setPublishedYear(int publishedYear) {
		this.publishedYear = publishedYear;
	}



	public String getTypeOfMovie() {
		return typeOfMovie;
	}



	public void setTypeOfMovie(String typeOfMovie) {
		this.typeOfMovie = typeOfMovie;
	}



	public String getExplanation() {
		return explanation;
	}



	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}



	public String getMedia() {
		return media;
	}



	public void setMedia(String media) {
		this.media = media;
	}



	public List<String> getLanguages() {
		return languages;
	}



	public void setLanguages(List<String> languages) {
		this.languages = languages;
	}



	public List<Actor> getActors() {
		return actors;
	}



	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}
	
	
	 

	
	
	
	
}
