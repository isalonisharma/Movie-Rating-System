package com.ratingdatamicroservice.models;

public class Rating {
	
	private Long id;
	private Long userId;
	private String movieId;
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
