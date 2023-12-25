package com.dab.videoclub.services;

import java.util.List;

import com.dab.videoclub.entities.Category;

public interface CategoryService {
	
	List<Category> findAll();
	
	Category findByCategory(String category);
	
	void delete(Category category);

}
