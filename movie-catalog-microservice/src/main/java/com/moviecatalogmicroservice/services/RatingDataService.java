package com.moviecatalogmicroservice.services;

import com.moviecatalogmicroservice.models.UserRating;

public interface RatingDataService {

	UserRating getUserRating(String userId);
}
