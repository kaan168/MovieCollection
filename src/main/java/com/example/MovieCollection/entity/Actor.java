package com.example.MovieCollection.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Actor {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	private Long id;
	
	private String name;
	
	@Column(nullable = true)
	private String role;
	

	
	@ManyToOne
	@JoinColumn(name="movie_id")
	private Movie movie;
	
	
	 

	




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









	public String getRole() {
		return role;
	}









	public void setRole(String role) {
		this.role = role;
	}









	public Movie getMovie() {
		return movie;
	}









	public void setMovie(Movie movie) {
		this.movie = movie;
	}









	@Override
	public String toString() {
		return ""+name+"";
	}
	
}
