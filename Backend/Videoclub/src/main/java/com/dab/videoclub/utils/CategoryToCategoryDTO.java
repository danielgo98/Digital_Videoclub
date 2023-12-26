package com.dab.videoclub.utils;

import com.dab.videoclub.dto.CategoryDTO;
import com.dab.videoclub.entities.Category;

public class CategoryToCategoryDTO {
	
	public static CategoryDTO convertToDTO(Category category) {
		
		CategoryDTO dto = CategoryDTO.builder()
				.id(category.getId())
				.category(category.getCategory())
				.build();
		
		return dto;
	}
	
	public static Category converToDomain(CategoryDTO dto) {
		
		Category category = Category.builder()
				.id(dto.getId())
				.category(dto.getCategory())
				.build();
		
		return category;
	}
}