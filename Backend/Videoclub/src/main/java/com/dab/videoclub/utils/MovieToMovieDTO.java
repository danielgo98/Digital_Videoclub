package com.dab.videoclub.utils;

import com.dab.videoclub.dto.MovieDTO;
import com.dab.videoclub.entities.Movie;

public class MovieToMovieDTO {
	
	public static MovieDTO convertToDTO(Movie movie) {
		
		MovieDTO dto = MovieDTO.builder()
				.id(movie.getId())
				.title(movie.getTitle())
				.image(movie.getImage())
				.releaseDate(movie.getReleaseDate())
				.synopsis(movie.getSynopsis())
				.director(movie.getDirector())
				.trailer(movie.getTrailer())
				.categories(movie.getCategories())
				.build();
		
		return dto;
		
	}
	
	public static Movie convertToDomain(MovieDTO dto) {
		
		Movie movie = Movie.builder()
				.id(dto.getId())
				.title(dto.getTitle())
				.image(dto.getImage())
				.releaseDate(dto.getReleaseDate())
				.synopsis(dto.getSynopsis())
				.director(dto.getDirector())
				.trailer(dto.getTrailer())
				.categories(dto.getCategories())
				.build();
		
		return movie;
	}

}
