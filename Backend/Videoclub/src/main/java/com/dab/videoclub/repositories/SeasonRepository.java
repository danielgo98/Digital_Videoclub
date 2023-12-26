package com.dab.videoclub.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dab.videoclub.entities.Season;

public interface SeasonRepository extends JpaRepository<Season, Long>{
	
	@Query(value = "SELECT se from Season se LEFT JOIN fetch se.serie WHERE se.serie.title = :name")
	List<Season> findBySerieName(@Param("name")String name);
	
}
