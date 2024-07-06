package com.dab.videoclub.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dab.videoclub.dto.MovieDTO;
import com.dab.videoclub.entities.Movie;
import com.dab.videoclub.services.MovieService;
import com.dab.videoclub.utils.MovieToMovieDTO;

@RestController
@RequestMapping(value = "/movie")
public class MovieController {

	@Autowired
	private MovieService movieService;

	@GetMapping("/")
	public ResponseEntity<?> getAll() {

		List<Movie> movies = movieService.findAll();
		List<MovieDTO> moviesDTO = movies.stream().map(movie -> MovieToMovieDTO.convertToDTO(movie))
				.collect(Collectors.toList());

		return ResponseEntity.status(HttpStatus.OK).body(moviesDTO);

	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getMovieById(@PathVariable("id") Long id) {

		Movie movie = movieService.findById(id);

		if (movie == null) {
			Map<String, String> errorMap = new HashMap<>();
			errorMap.put("Error", "Movie with id " + id + " not found");

			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMap);
		}

		MovieDTO movieDTO = MovieToMovieDTO.convertToDTO(movie);
		return ResponseEntity.status(HttpStatus.OK).body(movieDTO);

	}

	@GetMapping("/title/{title}")
	public ResponseEntity<?> getMovieByTitle(@PathVariable("title") String title) {

		List<Movie> movies = movieService.findByTitle(title);

		if (movies.isEmpty()) {
			Map<String, String> errorMap = new HashMap<>();
			errorMap.put("Error", "Movie with name " + title + " not found");

			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMap);
		}

		List<MovieDTO> moviesDTO = movies.stream().map(movie -> MovieToMovieDTO.convertToDTO(movie))
				.collect(Collectors.toList());

		return ResponseEntity.status(HttpStatus.OK).body(moviesDTO);

	}

}
