package com.ratingdatamicroservice.services;

import com.ratingdatamicroservice.beans.RatingResponse;
import com.ratingdatamicroservice.beans.UserRatingResponse;
import com.ratingdatamicroservice.models.Rating;

public interface RatingService {
	Rating getMovieRating(String movieId);

	Rating createMovieRating(Rating rating);
	
	RatingResponse convertToRatingResponse(Rating rating);
	
	UserRatingResponse getUserRatings(String userId);
}
