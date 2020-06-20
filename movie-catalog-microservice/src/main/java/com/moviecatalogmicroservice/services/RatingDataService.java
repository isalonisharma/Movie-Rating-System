package com.moviecatalogmicroservice.services;

import com.moviecatalogmicroservice.models.response.UserRatingResponse;

public interface RatingDataService {
	UserRatingResponse getUserRating(String userId);
}
