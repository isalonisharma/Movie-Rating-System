package com.ratingdatamicroservice.services;

import com.ratingdatamicroservice.models.Rating;
import com.ratingdatamicroservice.models.response.RatingResponse;
import com.ratingdatamicroservice.models.response.UserRatingResponse;

public interface RatingService {
	Rating getMovieRating(String movieId);

	Rating createMovieRating(Rating rating);
	
	RatingResponse convertToRatingResponse(Rating rating);
	
	UserRatingResponse getUserRatings(String userId);

	Rating updateMovieRating(Rating rating);
}
