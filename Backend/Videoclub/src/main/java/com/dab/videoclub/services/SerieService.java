package com.dab.videoclub.services;

import java.util.List;

import com.dab.videoclub.entities.Serie;
import com.dab.videoclub.exceptions.CategoryNotFoundException;

public interface SerieService {
	
	List<Serie> findAll();
	
	Serie findById(long id);
	
	List<Serie> findByName(String title);
	
	Serie save(Serie serie) throws CategoryNotFoundException;
	
	void delete(Serie serie);

}
