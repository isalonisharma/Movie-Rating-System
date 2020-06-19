package com.ratingdatamicroservice.services;

import com.ratingdatamicroservice.models.UserRating;

public interface UserRatingService {
	UserRating getUserRatings(String userId);
}
