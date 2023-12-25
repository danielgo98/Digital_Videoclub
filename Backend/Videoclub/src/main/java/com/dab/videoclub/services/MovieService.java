package com.dab.videoclub.services;

import java.util.List;

import com.dab.videoclub.entities.Movie;

public interface MovieService {
	
	List<Movie> findAll();
	
	Movie findById(long id);
	
	List<Movie> findByTitle(String title);
	
	Movie save(Movie movie);
	
	void delete(Movie movie);

}
