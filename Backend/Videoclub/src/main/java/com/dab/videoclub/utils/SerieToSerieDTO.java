package com.dab.videoclub.utils;

import java.util.Arrays;
import java.util.stream.Collectors;

import com.dab.videoclub.dto.SerieDTO;
import com.dab.videoclub.entities.Category;
import com.dab.videoclub.entities.Serie;

public class SerieToSerieDTO {
	
	public static SerieDTO convertToDTO(Serie serie) {
		
		SerieDTO dto = SerieDTO.builder()
				.id(serie.getId())
				.title(serie.getTitle())
				.image(serie.getImage())
				.numberSeasons(serie.getNumberSeasons())
				.releaseDate(serie.getReleaseDate())
				.synopsis(serie.getSynopsis())
				.categories(serie.getCategories().stream()
						.map(Category::getCategory)
						.toArray(String[]::new))
				.seasons(serie.getSeasons())
				.build();
		
		return dto;
	}
	
	public static Serie convertToEntity(SerieDTO dto) {
		
		Serie serie = Serie.builder()
				.id(dto.getId())
				.title(dto.getTitle())
				.image(dto.getImage())
				.numberSeasons(dto.getNumberSeasons())
				.releaseDate(dto.getReleaseDate())
				.synopsis(dto.getSynopsis())
				.categories(Arrays.stream(dto.getCategories())
						.map(categoryName -> new Category(categoryName))
						.collect(Collectors.toList()))
				.seasons(dto.getSeasons())
				.build();
		
		return serie;
	}
}