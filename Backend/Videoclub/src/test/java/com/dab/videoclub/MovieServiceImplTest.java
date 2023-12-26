package com.dab.videoclub;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dab.videoclub.entities.Movie;
import com.dab.videoclub.repositories.CategoryRepository;
import com.dab.videoclub.repositories.MovieRepository;
import com.dab.videoclub.services.MovieServiceImpl;

@ExtendWith(MockitoExtension.class)
public class MovieServiceImplTest {
	
	@Mock
	private MovieRepository movieRepository;
	
	@Mock
	private CategoryRepository categoryRepository;
	
	@InjectMocks
	private MovieServiceImpl movieService;
	
	
	@Test
	public void testFindByIdWithValidId() {
		Movie expectedMovie = new Movie();
		
		when(movieRepository.findById(anyLong()))
		.thenReturn(Optional.of(expectedMovie));
		
		Movie actualMovie = movieService.findById(1L);
		
		assertEquals(expectedMovie, actualMovie);
		
	}
	
	@Test
	public void testFindByIdWithInvalidId() {
		when(movieRepository.findById(anyLong()))
		.thenReturn(Optional.empty());
		
		Movie actualMovie = movieService.findById(Long.MAX_VALUE);
		
		assertNull(actualMovie);
	}
	
	@Test
	public void testFindByTitleWithValidName() {
		List<Movie> expectedMovies = Arrays.asList(new Movie());
		when(movieRepository.findByTitle(anyString()))
		.thenReturn(expectedMovies);
		
		List<Movie> actualMovies = movieService.findByTitle("an");
		
		assertEquals(expectedMovies, actualMovies);
		
	}
	
	@Test
	public void testFindByTitleWithInvalidName() {
		when(movieRepository.findByTitle(anyString()))
		.thenReturn(Collections.emptyList());
		
		List<Movie> movies = movieService.findByTitle("Pelicula de ejemplo");
		
		assertNotNull(movies);
		assertEquals(Collections.emptyList(), movies);
	}

}