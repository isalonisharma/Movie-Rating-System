package com.moviecatalogmicroservice.services;

import com.moviecatalogmicroservice.beans.UserRatingResponse;

public interface RatingDataService {
	UserRatingResponse getUserRating(String userId);
}
