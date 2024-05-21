package com.dab.videoclub.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dab.videoclub.dto.SerieDTO;
import com.dab.videoclub.entities.Serie;
import com.dab.videoclub.services.SerieService;
import com.dab.videoclub.utils.SerieToSerieDTO;

@RestController
@RequestMapping(value = "/serie")
public class SerieController {
	
	@Autowired
	private SerieService serieService;
	
	@GetMapping("/")
	public ResponseEntity<?> getAll(){
		
		List<Serie> series = serieService.findAll();
		List<SerieDTO> seriesDTO = series.stream()
				.map(serie -> SerieToSerieDTO.convertToDTO(serie))
				.collect(Collectors.toList());
		
		return ResponseEntity.status(HttpStatus.OK).body(seriesDTO);	
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getSerieById(@PathVariable("id") Long id){
		
		Serie serie = serieService.findById(id);
		
		if(serie == null) {
			
			Map<String, String> errorMap = new HashMap<>();
			errorMap.put("Error", "Serie with id " + id + " not found");
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMap);			
		}
		
		SerieDTO serieDTO = SerieToSerieDTO.convertToDTO(serie);
		return ResponseEntity.status(HttpStatus.FOUND).body(serieDTO);
		
	}
	
	@GetMapping("/name/{name}")
	public ResponseEntity<?> getSerieByName(@PathVariable("name") String name){
		
		List<Serie> series = serieService.findByName(name);
		
		if(series.isEmpty()) {	
			Map<String, String> errorMap = new HashMap<>();
			errorMap.put("Error", "Serie with name " + name + " not found");
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMap);
		}
		
		List<SerieDTO> seriesDTO = series.stream()
				.map(serie -> SerieToSerieDTO.convertToDTO(serie))
				.collect(Collectors.toList());
		
		return ResponseEntity.status(HttpStatus.FOUND).body(seriesDTO);
		
	}

}
