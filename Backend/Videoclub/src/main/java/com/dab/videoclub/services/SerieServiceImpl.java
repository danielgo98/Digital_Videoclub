package com.dab.videoclub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dab.videoclub.entities.Serie;
import com.dab.videoclub.repositories.SerieRepository;

@Service
@Transactional
public class SerieServiceImpl implements SerieService{
	
	@Autowired
	private SerieRepository serieRepository;

	@Override
	public List<Serie> findAll() {
		return serieRepository.findAll();
	}

	@Override
	public Serie findById(long id) {
		Optional<Serie> serie = serieRepository.findById(id);
		return serie.isPresent() ? serie.get() : null;
	}

	@Override
	public List<Serie> findByName(String title) {	
		List<Serie> series = serieRepository.findByName(title);
		return series.isEmpty() ? null : series;
	}

	@Override
	public Serie findSerieWithSeasons(String title) {
		return serieRepository.findSerieWithSeasons(title);
	}

	@Override
	public Serie save(Serie serie) {
		return serieRepository.save(serie);
	}

	@Override
	public void delete(Serie serie) {
		serieRepository.delete(serie);
	}

}
