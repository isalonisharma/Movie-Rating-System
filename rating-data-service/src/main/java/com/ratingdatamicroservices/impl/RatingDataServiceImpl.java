package com.ratingdatamicroservices.impl;

import org.springframework.stereotype.Service;

import com.ratingdatamicroservice.models.Rating;
import com.ratingdatamicroservice.models.UserRating;
import com.ratingdatamicroservice.services.RatingDataService;

@Service
public class RatingDataServiceImpl implements RatingDataService {

	@Override
	public Rating getMovieRating(String movieId) {
		return new Rating(1L, movieId, 4);
	}

	@Override
	public UserRating getUserRatings(String userId) {
		UserRating userRatings = new UserRating();
		userRatings.initData(userId);
		return userRatings;
	}

}
