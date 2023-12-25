package com.dab.videoclub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dab.videoclub.entities.Category;
import com.dab.videoclub.repositories.CategoryRepository;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public List<Category> findAll() {
		return categoryRepository.findAll();
	}

	@Override
	public Category findByCategoryOrCreate(String name) {	
		Category category = null;
		
		Optional<Category> categoryOpt = categoryRepository.findByCategory(name);
		
		if(categoryOpt.isPresent()) {
			category = categoryOpt.get();
		}else {
			category = new Category(name);
			categoryRepository.save(category);
		}
		
		return category;
	}

	@Override
	public void delete(Category category) {
		categoryRepository.delete(category);
	}

}
