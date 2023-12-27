package com.dab.videoclub.services;

import java.util.List;

import com.dab.videoclub.entities.Season;

public interface SeasonService {
	
	Season findById(long id);
	
	List<Season> findBySerieName(String name);
	
	Season save(Season season);
	
	void delete(Season season);

}
