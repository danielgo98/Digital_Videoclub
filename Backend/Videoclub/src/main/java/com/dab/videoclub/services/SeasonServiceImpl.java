package com.dab.videoclub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dab.videoclub.entities.Season;
import com.dab.videoclub.repositories.SeasonRepository;

@Service
@Transactional
public class SeasonServiceImpl implements SeasonService{
	
	@Autowired
	private SeasonRepository seasonRepository;
	
	@Override
	public Season findById(long id) {
		Optional<Season> season = seasonRepository.findById(id);
		return season.isPresent() ? season.get() : null;
	}

	@Override
	public List<Season> findBySerieName(String name) {
		return seasonRepository.findBySerieName(name);
	}

	@Override
	public Season save(Season season) {
		return seasonRepository.save(season);
	}

	@Override
	public void delete(Season season) {
		seasonRepository.delete(season);
	}

}
