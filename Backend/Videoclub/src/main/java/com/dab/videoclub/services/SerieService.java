package com.dab.videoclub.services;

import java.util.List;

import com.dab.videoclub.entities.Serie;

public interface SerieService {
	
	List<Serie> findAll();
	
	Serie findById(long id);
	
	List<Serie> findByName(String title);
	
	Serie findSerieWithSeasons(String title);
	
	Serie save(Serie serie);
	
	void delete(Serie serie);

}
