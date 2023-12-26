package com.dab.videoclub;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dab.videoclub.entities.Season;
import com.dab.videoclub.repositories.SeasonRepository;
import com.dab.videoclub.services.SeasonServiceImpl;

@ExtendWith(MockitoExtension.class)
public class SeasonServiceImplTest {
	
	@Mock
	private SeasonRepository seasonRepository;
	
	@InjectMocks
	private SeasonServiceImpl seasonService;
	
	
	@Test
	public void testFindBySerieWithValidName() {
		List<Season> expectedSeasons = Arrays.asList(new Season());
		
		when(seasonRepository.findBySerieName(anyString()))
		.thenReturn(expectedSeasons);
		
		List<Season> actualSeasons = seasonService.findBySerieName("One Piece");
		
		assertEquals(expectedSeasons, actualSeasons);
	}
	
	@Test
	public void testFindBySerieWithInvalidName() {
		
		when(seasonRepository.findBySerieName(anyString()))
		.thenReturn(Collections.emptyList());
		
		List<Season> seasons = seasonService.findBySerieName("Serie que no existe");
		
		assertNotNull(seasons);
		assertEquals(Collections.emptyList(), seasons);
		
	}
}
