package com.dab.videoclub;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.dab.videoclub.entities.Movie;
import com.dab.videoclub.services.MovieService;

@SpringBootApplication
public class VideoclubApplication implements CommandLineRunner{
	
	@Autowired
	private MovieService movieService;

	public static void main(String[] args) throws IOException {
//		ConfigurableApplicationContext ctx = SpringApplication.run(VideoclubApplication.class, args);
//		System.in.read();
//		ctx.close();
		SpringApplication.run(VideoclubApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		testFindAllMovies();
	}
	
	private void testFindAllMovies() {
		List<Movie> movies = movieService.findAll();
		System.out.println("ALL MOVIES");
		movies.forEach(Movie::getTitle);
	}

}
