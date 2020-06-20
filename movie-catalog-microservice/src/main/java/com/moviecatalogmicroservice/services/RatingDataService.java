package com.moviecatalogmicroservice.services;

import com.moviecatalogmicroservice.models.responses.UserRatingResponse;

public interface RatingDataService {
	UserRatingResponse getUserRating(String userId);
}
