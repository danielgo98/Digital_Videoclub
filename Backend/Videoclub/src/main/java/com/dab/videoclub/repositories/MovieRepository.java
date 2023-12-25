package com.dab.videoclub.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dab.videoclub.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {
	
	@Query(value = "SELECT m, c.category FROM Movie m LEFT JOIN fetch m.categories c WHERE m.id = :id")
	Movie findById(@Param("id") long id);
	
	@Query(value = "SELECT m, c.category FROM Movie m LEFT JOIN fetch m.categories c WHERE m.title = :title")
	List<Movie> findByTitle(@Param("title") String name);

}
