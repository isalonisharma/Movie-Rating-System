package com.ratingdatamicroservice.services;

import com.ratingdatamicroservice.models.Rating;

public interface MovieRatingService {
	Rating getMovieRating(String movieId);
}
