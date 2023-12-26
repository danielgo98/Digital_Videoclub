package com.dab.videoclub;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dab.videoclub.entities.Serie;
import com.dab.videoclub.services.SerieService;

@SpringBootApplication
public class VideoclubApplication implements CommandLineRunner{
	
	@Autowired
	private SerieService serieService;
	

	public static void main(String[] args) throws IOException {
//		ConfigurableApplicationContext ctx = SpringApplication.run(VideoclubApplication.class, args);
//		System.in.read();
//		ctx.close();
		SpringApplication.run(VideoclubApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		testFindAllSeries();
	}
	
	private void testFindAllSeries() {
		
		List<Serie> series = serieService.findAll();
		
		System.out.println("ALL SERIES");
		series.forEach(serie -> {
			System.out.println(serie.toString());
		});
		
	}

}
