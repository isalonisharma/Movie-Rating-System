package com.ratingdatamicroservice.models;

public class Rating {
	private Long id;
	private String movieId;
	private Integer rating;

	public Rating() {

	}

	public Rating(Long id, String movieId, Integer rating) {
		super();
		this.id = id;
		this.movieId = movieId;
		this.rating = rating;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Rating [id=" + id + ", movieId=" + movieId + ", rating=" + rating + "]";
	}
}
