package com.dab.videoclub;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.dab.videoclub.entities.Category;
import com.dab.videoclub.entities.Movie;
import com.dab.videoclub.exceptions.CategoryNotFoundException;
import com.dab.videoclub.services.CategoryService;
import com.dab.videoclub.services.MovieService;

@SpringBootApplication
public class VideoclubApplication implements CommandLineRunner{
	
	@Autowired
	private MovieService movieService;
	
	@Autowired
	private CategoryService categoryService;

	public static void main(String[] args) throws IOException {
//		ConfigurableApplicationContext ctx = SpringApplication.run(VideoclubApplication.class, args);
//		System.in.read();
//		ctx.close();
		SpringApplication.run(VideoclubApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Category catAccion = categoryService.findByCategory("Accion");
		Category catDrama = categoryService.findByCategory("Drama");
		
		Movie movie = Movie.builder()
				.title("Pelicula de ejemplo: parte 2")
				.image("imagen 2dfsdf")
				.releaseDate(LocalDate.now().plusDays(23))
				.synopsis("Una pelicula")
				.director("Daniel")
				.trailer("Un trailer, de la pelicula")
				.categories(Arrays.asList(catAccion, catDrama))
				.build();
//		testFindAllMovies();
//		testFindById(1);
//		testFindByName("Guardianes de la Galaxia");
//		testCreateMovie(movie);
		testDeleteMovie(13);
	}
	
	private void testFindAllMovies() {
		List<Movie> movies = movieService.findAll();
		System.out.println("ALL MOVIES");
		movies.forEach(System.out::println);
	}
	
	private void testFindById(long id) {
		Movie movie = movieService.findById(id);
		
		if(movie != null) {
			System.out.println("Movie found");
			System.out.println(movie);
		}else {
			System.out.println("Movie not found");
		}
		
	}
	
	private void testFindByName(String title) {
		List<Movie> movies = movieService.findByTitle(title);
		
		if(!movies.isEmpty()) {
			movies.forEach(System.out::println);
		}else {
			System.out.println("No movies found");
		}
		
	}
	
	private void testCreateMovie(Movie movie) {
		try {
			movieService.save(movie);
			System.out.println("Pelicula guardada");
		} catch (CategoryNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	
	private void testDeleteMovie(long id) {
		Movie m = movieService.findById(id);
		
		if(m != null) {
			movieService.delete(m);
			System.out.println("Movie deleted");
		}else {
			System.out.println("Movie not found");
		}
		
	}

}
