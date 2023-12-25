package com.dab.videoclub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dab.videoclub.entities.Movie;
import com.dab.videoclub.repositories.MovieRepository;

@Service
@Transactional
public class MovieServiceImpl implements MovieService{
	
	@Autowired
	private MovieRepository movieRepository;

	@Override
	public List<Movie> findAll() {
		return movieRepository.findAll();
	}

	@Override
	public Movie findById(long id) {
		return movieRepository.findById(id);
	}

	@Override
	public List<Movie> findByTitle(String title) {
		List<Movie> movies = movieRepository.findByTitle(title);
		return movies.isEmpty() ? null : movies;
	}

	@Override
	public Movie save(Movie movie) {
		return movieRepository.save(movie);
	}

	@Override
	public void delete(Movie movie) {
		movieRepository.delete(movie);
	}

}
