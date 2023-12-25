package com.dab.videoclub.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
@Table(name = "MOVIES")
public class Movie implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_MOVIE")
	private int id;
	
	@Column(name = "TITLE")
	private String title;
	
	@Column(name = "IMAGE")
	private String image;
	
	@Column(name = "RELEASE_DATE")
	private LocalDate releaseDate;
	
	@Column(name = "SYNOPSIS")
	private String synopsis;
	
	@Column(name = "DIRECTOR")
	private String director;
	
	@Column(name = "TRAILER")
	private String trailer;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinTable(
			name = "MOVIE_CATEGORY", 
			joinColumns = @JoinColumn(name = "ID_MOVIE"),
			inverseJoinColumns = @JoinColumn(name = "ID_CATEGORY"))
	private List<Category> categories;

}
