package com.moviecatalogservice.models;

public class Catalog {
	private String movieName;
	private String movieDescription;
	private Integer movieRating;
	
	public Catalog() {
		
	}

	public Catalog(String movieName, String movieDescription, Integer movieRating) {
		super();
		this.movieName = movieName;
		this.movieDescription = movieDescription;
		this.movieRating = movieRating;
	}
	
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getMovieDescription() {
		return movieDescription;
	}
	public void setMovieDescription(String movieDescription) {
		this.movieDescription = movieDescription;
	}
	public Integer getMovieRating() {
		return movieRating;
	}

	public void setMovieRating(Integer movieRating) {
		this.movieRating = movieRating;
	}

	@Override
	public String toString() {
		return "Catalog [movieName=" + movieName + ", movieDescription=" + movieDescription + ", movieRating="
				+ movieRating + "]";
	}
}
