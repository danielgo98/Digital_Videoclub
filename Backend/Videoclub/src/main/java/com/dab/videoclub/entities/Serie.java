package com.dab.videoclub.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
import jakarta.persistence.OneToMany;
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
@Table(name = "SERIES")
public class Serie implements Serializable{

	private static final long serialVersionUID = -1513802177901690712L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_SERIE")
	private Long id;
	
	@Column(name = "TITLE")
	private String title;
	
	@Column(name = "IMAGE")
	private String image;
	
	@Column(name = "NUMBER_SEASONS")
	private int numberSeasons;
	
	@Column(name = "RELEASE_DATE")
	private LocalDate releaseDate;
	
	@Column(name = "SYNOPSIS")
	private String synopsis;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinTable(name = "SERIE_CATEGORY",
			   joinColumns = @JoinColumn(name = "ID_SERIE"),
			   inverseJoinColumns = @JoinColumn(name = "ID_CATEGORY"))
	private List<Category> categories;
	
	@JsonIgnore
	@OneToMany(mappedBy = "serie",
			   cascade = CascadeType.ALL,
			   orphanRemoval = true,
			   fetch = FetchType.LAZY)
	private List<Season> seasons;
	
	public Serie(Long id) {
		this.id = id;
	}
	
}
