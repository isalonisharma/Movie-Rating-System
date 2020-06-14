package com.movieinfomicroservice.services;

import com.movieinfomicroservice.models.Movie;

public interface MovieInfoService {
	public Movie getMovie(String movieId);
}
