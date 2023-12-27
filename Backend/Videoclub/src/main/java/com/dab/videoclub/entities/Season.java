package com.dab.videoclub.entities;

import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "SEASONS")
public class Season implements Serializable{

	private static final long serialVersionUID = 7059501155009068614L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_SEASON")
	private Long id;
	
	@Column(name = "SEASON_NAME")
	private String name;
	
	@Column(name = "CHAPTERS")
	private int chapters;
	
	@Column(name = "RELEASE_DATE")
	private LocalDate releaseDate;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "SERIE_ID")
	private Serie serie;
	
	@Column(name = "TRAILER")
	private String trailer;

}
