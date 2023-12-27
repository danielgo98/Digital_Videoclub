package com.dab.videoclub.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MovieDTO {
	
	private Long id;
	
	private String title;
	
	private String image;
	
	private LocalDate releaseDate;
	
	private String synopsis;
	
	private String director;
	
	private String trailer;
	
	private String[] categories;

}
