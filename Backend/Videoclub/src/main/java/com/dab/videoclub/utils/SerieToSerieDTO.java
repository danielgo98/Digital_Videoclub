package com.dab.videoclub.utils;

import com.dab.videoclub.dto.SerieDTO;
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
				.categories(serie.getCategories())
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
				.categories(dto.getCategories())
				.seasons(dto.getSeasons())
				.build();
		
		return serie;
	}
}