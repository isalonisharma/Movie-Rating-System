package com.ratingdatamicroservice.models;

import javax.validation.constraints.NotNull;

public class Rating {
	
	private Long id;
	
	@NotNull(message = "userId is required")
	private Long userId;
	
	@NotNull(message = "movieId is required")
	private String movieId;
	
	@NotNull(message = "rating is required")
	private Integer rating;

	public Rating() {
		super();
	}

	public Rating(Long id, Long userId, String movieId, Integer rating) {
		super();
		this.id = id;
		this.userId = userId;
		this.movieId = movieId;
		this.rating = rating;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
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
		return "Rating [id=" + id + ", userId=" + userId + ", movieId=" + movieId + ", rating=" + rating + "]";
	}
}
