package com.dab.videoclub.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dab.videoclub.entities.Serie;

public interface SerieRepository extends JpaRepository<Serie, Long> {
	
	@Query(value = "SELECT s, se, ca.category FROM Serie s "
			+ "LEFT JOIN fetch s.seasons se "
			+ "LEFT JOIN fetch s.categories ca WHERE s.id = :id")
	Optional<Serie> findById(@Param("id") long id);

	@Query(value = "SELECT s, c.category FROM Serie s LEFT JOIN fetch s.categories c WHERE s.title = :title")
	List<Serie> findByName(@Param("title") String title);
	
	@Query(value = "SELECT s FROM Serie s LEFT JOIN fetch s.seasons se WHERE s.title = :title")
	Serie findSerieWithSeasons(@Param("title") String title);
	
}
