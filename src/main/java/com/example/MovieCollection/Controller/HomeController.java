package com.example.MovieCollection.Controller;


import javax.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import com.example.MovieCollection.entity.Actor;
import com.example.MovieCollection.entity.Movie;
import com.example.MovieCollection.entity.User;
import com.example.MovieCollection.service.ActorService;
import com.example.MovieCollection.service.MovieService;
import com.example.MovieCollection.service.UserService;
import com.example.MovieCollection.shared.ActorString;



@Controller
public class HomeController {

	
	@Autowired
	UserService userService;
	
	
	@Autowired
	MovieService movieService; 
	
	@Autowired
	ActorService actorService;
	
	
	@ModelAttribute("user")
	public User Userx() {
		return new User();
	}
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String loginx() {
	
		
		
		return "login";
		
	
	}
	
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signup()
	{
		
		return "signup";
	}
	 
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
	
		 
		
		return "login";
		 
	
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(@ModelAttribute("movie") Movie movie ,Model model,Model model2) {
	
		
		List<Movie> movies=movieService.getall();
		
	
		model.addAttribute("movies",movies);
		model2.addAttribute("actors",movie.getActors());
		
		
		
		return "home";
		
	
	}
	
	
	
	
	String sarc="";
	
	@RequestMapping(value = "/home/search" ,method = RequestMethod.POST)
	public String process(@RequestParam String name) {
		sarc=null;
		sarc=name;
	
		return "/home";
	}
	
	@RequestMapping(value ="/home/search", method =RequestMethod.GET)
	public String searchx(@RequestParam(value = "name",required = false) String name,Model model) {
		
		
		
		List<Movie> queriedMoviesList=new ArrayList<Movie>();
		
		for (Movie movie : movieService.queryByName(name)) {
			queriedMoviesList.add(movie);
		}
		for (Movie movie : movieService.queryByTypeOfMovie(name)) {
			queriedMoviesList.add(movie);
		}
			for(Actor actor:actorService.queryByName(name)) {
				queriedMoviesList.add(movieService.getById(actor.getMovie().getId()));
				}
			
		
		
		
		
		model.addAttribute("queriedMovies", queriedMoviesList);
		
		return "searchPage";
}
	@RequestMapping(value = "/search/year",method = RequestMethod.GET)
	public String orderByYear(Model model) {
		
		model.addAttribute("orderByMovie",movieService.sortByYear());
		
		return "orderByYear.html";
	}
	
	 
	  
	
	
	
	
	
	
	
	@RequestMapping(value = "/addmovie", method = RequestMethod.GET)
	public String addMovie(Model model) {
		
		List<Actor> actors = null;
		 model.addAttribute("actors",actors);
		
		return "addmovie";
		   	
	 
	}
	
	@ModelAttribute("movie")
	public Movie loadMovie(){
	   return new Movie();
	}
	


	@PostMapping("/addmovie")
	public String addMovie(@ModelAttribute("movie") Movie movie ,Model model) {
		
	
		movieService.save(movie);
		 
		
		
		return "redirect:/addActor/"+movie.getId();
		
	
	}
	@RequestMapping(path = "/addActor/{id}",method = RequestMethod.GET)
	public String addActor(@PathVariable (name = "id") Long id,Model model) {
		
		
		
		return "addActor";
	}
	
	
	
	
	@ModelAttribute("actorString")
	public ActorString loadActors(){
	   return new ActorString();
	}
	
	
	
	@RequestMapping( path="/update/updateActor/{id}",method = RequestMethod.POST)
	public String addActor2(@PathVariable(name = "id") Long id,@ModelAttribute("actorString") ActorString actor) {
		
		
		
		List<String> names =new ArrayList<String>();
		List<String> roles =new ArrayList<String>();
		List<Actor> actors=new ArrayList<>();
		
		
		
		
		if(actor.getRoles().isEmpty()) {
			List<String> y = new ArrayList<>(Arrays.asList(""));
			actor.setRoles(y);
		}
		
		for(int i=0;i<actor.getActors().size();i++) {
			
			if(actor.getRoles().get(i).isEmpty()) {
				roles.add(i, " ");
			}
			else {
				roles.add(i,actor.getRoles().get(i));
			}
			
		}
		
		
		for (String actrString: actor.getActors()) {
			names.add(actrString);
		}
	
		
	
		
		for(int i=0;i<names.size();i++) {
			Actor actor2=new Actor();
			actor2.setName(names.get(i));
			actor2.setRole(roles.get(i));
			actor2.setMovie(movieService.getById(id));
			
			actorService.save(actor2);
			actors.add(actor2);
			
			

		}
		
		
		Movie movie1=movieService.getById(id);
		movie1.setActors(actors);
		movieService.save(movie1);
	
		
		return "redirect:/home";
		
	
		 
		
	
		
		
	}
	
	
	
	
	
	
	@RequestMapping( path="/addActor/{id}",method = RequestMethod.POST)
	public String addActorx(@PathVariable(name = "id") Long id,@ModelAttribute("actorString") ActorString actor) {
		
		
		
		List<String> names =new ArrayList<String>();
		List<String> roles =new ArrayList<String>();
		List<Actor> actors=new ArrayList<>();
		
	
		if(actor.getRoles().isEmpty()) {
			List<String> y = new ArrayList<>(Arrays.asList(""));
			actor.setRoles(y);
		}
		
		for(int i=0;i<actor.getActors().size();i++) {
			
			if(actor.getRoles().get(i).isEmpty()) {
				roles.add(i, " ");
			}
			else {
				roles.add(i,actor.getRoles().get(i));
			}
			
		}
		
		
		for (String actrString: actor.getActors()) {
			names.add(actrString);
		}
	
		
	
		
		for(int i=0;i<names.size();i++) {
			Actor actor2=new Actor();
			actor2.setName(names.get(i));
			actor2.setRole(roles.get(i));
			actor2.setMovie(movieService.getById(id));
			
			actorService.save(actor2);
			actors.add(actor2);
			
			

		}
		
		
		Movie movie1=movieService.getById(id);
		movie1.setActors(actors);
		movieService.save(movie1);
	
		
		return "redirect:/home";
		
		
	
		
		
	}
	
	
	
	
	
	 @RequestMapping(path = "/signup", method = RequestMethod.POST)
	public String adduser(@ModelAttribute("user") User user) {
		
		
		userService.save(user);
		return "redirect:/login";
		

		
	} 
	 
	 @RequestMapping(path = "/login", method = RequestMethod.POST)
		public String login(@ModelAttribute("user") User user) {
		 
		 
		 
			if(userService.findbyName(user).equals(userService.findbyPass(user))) {
				return "redirect:/home";
				 
			}
			 
			return "redirect:/login";

			
		}
	 
	 @RequestMapping(path = "/detail/{id}",method = RequestMethod.GET)
	 public String x(@PathVariable(value = "id") Long id,Model model,HttpSession session) {
		  
		 
		 
		 model.addAttribute("gelen", movieService.getById(id));
		 String x="";
		 x=actorService.queryById(id).toString();
		 
		 session.setAttribute("value", x);
	
		
		 return "detail";
	 }
	 
	 
	 
	 
	 @RequestMapping(path = "/update/{id}",method = RequestMethod.POST)
	 public String updateMovie(@PathVariable(value = "id") Long id, @ModelAttribute("movie") Movie movie,Model model){
		 
		 
		 
		 Movie lastMovie=movieService.getById(id);
		
		
		 
		 lastMovie.setExplanation(movie.getExplanation());
		 lastMovie.setLanguages(movie.getLanguages());
		 lastMovie.setMedia(movie.getMedia());
		 lastMovie.setName(movie.getName());
		 lastMovie.setId(id);
		 
		 lastMovie.setPublishedYear(movie.getPublishedYear());
		 lastMovie.setTypeOfMovie(movie.getTypeOfMovie());
		 movieService.save(lastMovie);
		 
		 
		 return "redirect:/update/updateActor/"+id;
	 }
	 @RequestMapping(value = "/deleteActor/{id}", method = RequestMethod.GET)
	 public String deleteActor(@PathVariable (value = "id")Long id){
		 Actor actor=actorService.getOne(id);
		 Long iidLong=actor.getMovie().getId();
		 actorService.delete(id);
		 
		 
		 return "redirect:/update/updateActor/"+iidLong;
	 }
	 
	 
	 
	 
	 
	 @RequestMapping(path = "/update/{id}",method = RequestMethod.GET)
	 public String updatePage(@PathVariable(value = "id") Long id,Model model) {
		 
		 model.addAttribute("movie",movieService.getById(id));
		 
		 
		 return "update";
	 }
	 @RequestMapping(value = "/update/updateActor/{id}",method = RequestMethod.GET)
	 public String updateActor(@PathVariable (value = "id")Long id,Model model) {
		 
		 
		 model.addAttribute("actors",actorService.queryById(id));
		 
		 return "updateActor";
	 }
	 
	 
	 
	 @RequestMapping(path="/delete/{id}",method=RequestMethod.GET)
	 public String delete(@PathVariable(value="id") Long id){
		 movieService.delete(movieService.getById(id));
		 
		 return "redirect:/home";
	 }
	 
	 
	 
	 
	
	 
	 
}
