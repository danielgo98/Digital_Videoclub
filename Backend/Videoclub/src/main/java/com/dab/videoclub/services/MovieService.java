package com.dab.videoclub.services;

import java.util.List;

import com.dab.videoclub.entities.Movie;
import com.dab.videoclub.exceptions.CategoryNotFoundException;

public interface MovieService {
	
	List<Movie> findAll();
	
	Movie findById(long id);
	
	List<Movie> findByTitle(String title);
	
	Movie save(Movie movie) throws CategoryNotFoundException;
	
	void delete(Movie movie);

}
