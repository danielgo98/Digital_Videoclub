package com.dab.videoclub.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dab.videoclub.entities.Serie;

public interface SerieRepository extends JpaRepository<Serie, Long> {
	
	@Query(value = "SELECT s FROM Serie s LEFT JOIN fetch s.categories c WHERE s.title LIKE %:title%")
	List<Serie> findByName(@Param("title") String title);
	
}
