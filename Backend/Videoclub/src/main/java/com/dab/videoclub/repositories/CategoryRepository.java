package com.dab.videoclub.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dab.videoclub.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{
	
	@Query(value = "SELECT c FROM Category c WHERE c.category = :category")
	Optional<Category> findByCategory(@Param("category") String category);

}
