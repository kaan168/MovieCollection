package com.example.MovieCollection.shared;



import java.util.List;

public class ActorString {

	private List<String> actors;
	
	private List<String> roles;
	

	public List<String> getActors() {
		return actors;
	}

	public void setActors(List<String> actors) {
		this.actors = actors;
	}

	

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "ActorString [actors=" + actors + ", roles=" + roles + "]";
	}
	

	
	
}
