package com.dab.videoclub;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dab.videoclub.entities.Serie;
import com.dab.videoclub.repositories.CategoryRepository;
import com.dab.videoclub.repositories.SerieRepository;
import com.dab.videoclub.services.SerieServiceImpl;

@ExtendWith(MockitoExtension.class)
public class SerieServiceImplTest {
	
	@Mock
	private SerieRepository serieRepository;
	
	@Mock
	private CategoryRepository categoryRepository;
	
	@InjectMocks
	private SerieServiceImpl serieService;
	
	
	@Test
	public void testFindByIdWithValidId() {
		Serie expectedSerie = new Serie();
		
		when(serieRepository.findById(anyLong()))
		.thenReturn(Optional.of(expectedSerie));
		
		Serie actualSerie = serieService.findById(1);
		
		assertEquals(expectedSerie, actualSerie);
	}
	
	@Test
	public void testFindByIdWithInvalidId() {
		when(serieRepository.findById(anyLong()))
		.thenReturn(Optional.empty());
		
		Serie serie = serieService.findById(Long.MAX_VALUE);
		
		assertNull(serie);
	}
	
	@Test
	public void testFindBySerieNameWithValidSerie() {
		List<Serie> expectedSeries = Arrays.asList(new Serie());
		
		when(serieRepository.findByName(anyString()))
		.thenReturn(expectedSeries);
		
		List<Serie> actualSeries = serieService.findByName("Dra");
		
		assertEquals(expectedSeries, actualSeries);
	}
	
	@Test
	public void testFindBySerieNameWithInvalidSerie() {
		when(serieRepository.findByName(anyString()))
		.thenReturn(Collections.emptyList());
		
		List<Serie> series = serieService.findByName("Serie que no existe");
		
		assertNotNull(series);
		assertEquals(Collections.emptyList(), series);
		
	}
	

}
