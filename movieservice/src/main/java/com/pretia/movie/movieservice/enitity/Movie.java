package com.pretia.movie.movieservice.enitity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="IMBD_MOVIE_TAB")
@ApiModel(description = "This resources describes all properties of a Movie")
public class Movie {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@JsonIgnore
	Long id;
	
	@ApiModelProperty(notes = "IMDB Movie Id")
	@Column(name="IMBD_ID")
	@JsonProperty("imdbID")
	String imdbId;

	@ApiModelProperty(notes = "Movie Title")
	@Column(name="MOVIE_TITLE")
	@JsonProperty("Title")
	String title;
	
	@ApiModelProperty(notes = "Movie Release Year")
	@Column(name="MOVIE_YEAR")
	@JsonProperty("Year")
	int year;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public String getImdbId() {
		return imdbId;
	}

	public void setImdbId(String imdbId) {
		this.imdbId = imdbId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	

}
