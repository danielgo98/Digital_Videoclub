package com.dab.videoclub.dto;

import java.time.LocalDate;

import com.dab.videoclub.entities.Serie;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SeasonDTO {
	
	private Long id;
	
	private String name;
	
	private int chapters;
	
	private LocalDate releaseDate;
	
	private Serie serie;
	
	private String trailer;

}
