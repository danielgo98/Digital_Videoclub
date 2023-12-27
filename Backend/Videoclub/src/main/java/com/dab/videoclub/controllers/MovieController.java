package com.dab.videoclub.controllers;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dab.videoclub.dto.MovieDTO;
import com.dab.videoclub.exceptions.CategoryNotFoundException;
import com.dab.videoclub.services.MovieService;
import com.dab.videoclub.utils.MovieToMovieDTO;

@RestController
@RequestMapping(value = "/movie")
public class MovieController {
	
	@Autowired
	private MovieService movieService;
	
	@GetMapping("/")
	public ResponseEntity<?> getAll(){
		
		var movies = movieService.findAll();
		var moviesDTO = movies.stream().map(movie -> MovieToMovieDTO.convertToDTO(movie));
		
		return ResponseEntity.status(HttpStatus.OK).body(moviesDTO);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getMovieById(@PathVariable("id") Long id){
		
		var movie = movieService.findById(id);
		
		if(movie == null) {
			var errorMap = new HashMap<>();
			errorMap.put("Error", "Movie with id " + id + " not found");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMap);
		}
		
		var movieDTO = MovieToMovieDTO.convertToDTO(movie);
		return ResponseEntity.status(HttpStatus.FOUND).body(movieDTO);
		
	}
	
	@GetMapping("/title/{title}")
	public ResponseEntity<?> getMovieByTitle(@PathVariable("title") String title){
		
		var movies = movieService.findByTitle(title);
		
		if(movies.isEmpty()) {
			var errorMap = new HashMap<>();
			errorMap.put("Error", "Movie with name " + title + " not found");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMap);
		}
		
		var moviesDTO = movies.stream().map(movie -> MovieToMovieDTO.convertToDTO(movie));
		return ResponseEntity.status(HttpStatus.FOUND).body(moviesDTO);
		
	}
	
	@PostMapping("/")
	public ResponseEntity<?> createMovie(@RequestBody MovieDTO movieDTO){
		
		var movie = MovieToMovieDTO.convertToDomain(movieDTO);
		
		try {
			movieService.save(movie);
		} catch (CategoryNotFoundException e) {
			var errorMap = new HashMap<>();
			errorMap.put("Error", e.getMessage());
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(errorMap);
		}
		
		return ResponseEntity.status(HttpStatus.CREATED).body(movieDTO);
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateMovie(@RequestBody MovieDTO movieDTO, @PathVariable("id") Long id){
		
		if(!movieDTO.getId().equals(id)) {	
			var errorMap = new HashMap<>();
			errorMap.put("Error", "Ids not equals");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMap);
		}
		
		var movie = movieService.findById(id);
		
		if(movie == null) {
			var errorMap = new HashMap<>();
			errorMap.put("Error", "Movie with id " + id + " not found");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMap);
		}
		
		var movieSaved = MovieToMovieDTO.convertToDomain(movieDTO);
		
		try {
			
			movieService.save(movieSaved);
			
		} catch (CategoryNotFoundException e) {
			var errorMap = new HashMap<>();
			errorMap.put("Error", e.getMessage());
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(errorMap);
		}
		
		return ResponseEntity.status(HttpStatus.CREATED).body(movieDTO);		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteMovie(@PathVariable("id") Long id){
		
		var movie = movieService.findById(id);
		
		if(movie == null) {
			var errorMap = new HashMap<>();
			errorMap.put("Error", "Movie with id " + id + " not found");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMap);
		}
		
		movieService.delete(movie);
		return ResponseEntity.status(HttpStatus.OK).build();
		
	}
	

}
