package com.movieinformationmicroservice.services;

import com.movieinformationmicroservice.models.Movie;

public interface MovieInfoService {
	public Movie getMovie(String movieId);
}
