package com.dab.videoclub.dto;

import java.time.LocalDate;
import java.util.List;

import com.dab.videoclub.entities.Category;
import com.dab.videoclub.entities.Season;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SerieDTO {
	
	private int id;
	
	private String title;
	
	private String image;
	
	private int numberSeasons;
	
	private LocalDate releaseDate;
	
	private String synopsis;
	
	private String[] categories;
	
	private List<Season> seasons;

}
