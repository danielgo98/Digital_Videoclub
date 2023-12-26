package com.dab.videoclub.utils;

import com.dab.videoclub.dto.SeasonDTO;
import com.dab.videoclub.entities.Season;

public class SeasonToSeasonDTO {
	
	public static SeasonDTO convertToDTO(Season season) {
		
		SeasonDTO dto = SeasonDTO.builder()
				.id(season.getId())
				.name(season.getName())
				.chapters(season.getChapters())
				.releaseDate(season.getReleaseDate())
				.serie(season.getSerie())
				.trailer(season.getTrailer())
				.build();
		
		return dto;
	}
	
	public static Season convertToEntity(SeasonDTO dto) {
		
		Season season = Season.builder()
				.id(dto.getId())
				.name(dto.getName())
				.chapters(dto.getChapters())
				.releaseDate(dto.getReleaseDate())
				.serie(dto.getSerie())
				.trailer(dto.getTrailer())
				.build();
		
		return season;
		
	}

}
