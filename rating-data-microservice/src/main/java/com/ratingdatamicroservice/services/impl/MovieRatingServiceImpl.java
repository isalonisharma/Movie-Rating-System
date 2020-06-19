package com.ratingdatamicroservice.services.impl;

import org.springframework.stereotype.Service;

import com.ratingdatamicroservice.models.Rating;
import com.ratingdatamicroservice.services.MovieRatingService;

@Service
public class MovieRatingServiceImpl implements MovieRatingService {

	@Override
	public Rating getMovieRating(String movieId) {
		return new Rating(1L, movieId, 4);
	}

}
