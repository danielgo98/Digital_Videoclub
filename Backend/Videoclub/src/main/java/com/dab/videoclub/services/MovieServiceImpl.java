package com.dab.videoclub.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dab.videoclub.entities.Category;
import com.dab.videoclub.entities.Movie;
import com.dab.videoclub.exceptions.CategoryNotFoundException;
import com.dab.videoclub.repositories.CategoryRepository;
import com.dab.videoclub.repositories.MovieRepository;

@Service
@Transactional
public class MovieServiceImpl implements MovieService{
	
	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public List<Movie> findAll() {
		return movieRepository.findAll();
	}

	@Override
	public Movie findById(long id) {
		Optional<Movie> movie = movieRepository.findById(id);
		return movie.isPresent() ? movie.get() : null;
	}

	@Override
	public List<Movie> findByTitle(String title) {
		List<Movie> movies = movieRepository.findByTitle(title);
		return movies.isEmpty() ? Collections.emptyList() : movies;
	}

	@Override
	public Movie save(Movie movie) throws CategoryNotFoundException {
		
		List<Category> categoriesMovie = movie.getCategories();
		List<Category> managedCategories = new ArrayList<>();
		
		for(Category category: categoriesMovie) {
			
			if (category != null) {
				Optional<Category> managedCategory = categoryRepository.findByCategory(category.getCategory());

				if (managedCategory.isPresent()) {
					managedCategories.add(managedCategory.get());
				}
				
			} else {
				throw new CategoryNotFoundException("La categoria de la pelicula que ha añadido no se encuentra en nuestra base de datos.");
			}
		}
		
		if(managedCategories.isEmpty()) {
			throw new CategoryNotFoundException("La categoria de la pelicula que ha añadido no se encuentra en nuestra base de datos.");
		}
		
		movie.setCategories(managedCategories);
		return movieRepository.save(movie);
	}

	@Override
	public void delete(Movie movie) {
		movieRepository.delete(movie);
	}

}
