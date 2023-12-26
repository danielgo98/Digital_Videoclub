package com.dab.videoclub.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dab.videoclub.entities.Category;
import com.dab.videoclub.entities.Serie;
import com.dab.videoclub.exceptions.CategoryNotFoundException;
import com.dab.videoclub.repositories.CategoryRepository;
import com.dab.videoclub.repositories.SerieRepository;

@Service
@Transactional
public class SerieServiceImpl implements SerieService{
	
	@Autowired
	private SerieRepository serieRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;

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
		return series.isEmpty() ? Collections.emptyList() : series;
	}

	@Override
	public Serie save(Serie serie) throws CategoryNotFoundException{
		
		List<Category> categoriesSerie = serie.getCategories();
		List<Category> managedCategories = new ArrayList<>();
		
		for(Category category : categoriesSerie) {
			
			if (category != null) {

				Optional<Category> managedCategory = categoryRepository.findByCategory(category.getCategory());

				if (managedCategory.isPresent()) {
					managedCategories.add(managedCategory.get());
				} else {
					throw new CategoryNotFoundException("La categoria de la serie que ha añadido no se encuentra en nuestra base de datos.");
				}
			}
		}
		
		serie.setCategories(managedCategories);
		return serieRepository.save(serie);
	}

	@Override
	public void delete(Serie serie) {
		serieRepository.delete(serie);
	}

}
