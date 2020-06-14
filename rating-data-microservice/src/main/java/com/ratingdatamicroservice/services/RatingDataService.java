package com.ratingdatamicroservice.services;

import com.ratingdatamicroservice.models.Rating;
import com.ratingdatamicroservice.models.UserRating;

public interface RatingDataService {
	Rating getMovieRating(String movieId);

	UserRating getUserRatings(String userId);
}
