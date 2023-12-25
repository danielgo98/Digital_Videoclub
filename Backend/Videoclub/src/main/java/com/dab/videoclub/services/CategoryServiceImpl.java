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
	public Category findByCategory(String name) {	
		Optional<Category> category = categoryRepository.findByCategory(name);
		return category.isPresent() ? category.get() : null;
	}

	@Override
	public void delete(Category category) {
		categoryRepository.delete(category);
	}

}
