package com.ratingdatamicroservice.models.responses;

public class RatingResponse {
	private String movieId;
	private Integer rating;
	
	public RatingResponse() {
		super();
	}

	public RatingResponse(String movieId, Integer rating) {
		super();
		this.movieId = movieId;
		this.rating = rating;
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
		return "RatingResponse [movieId=" + movieId + ", rating=" + rating + "]";
	}
}