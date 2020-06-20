package com.ratingdatamicroservice.services.impl;

import org.springframework.stereotype.Service;

import com.ratingdatamicroservice.beans.RatingResponse;
import com.ratingdatamicroservice.beans.UserRatingResponse;
import com.ratingdatamicroservice.models.Rating;
import com.ratingdatamicroservice.services.RatingService;

@Service
public class RatingServiceImpl implements RatingService {

	@Override
	public Rating getMovieRating(String movieId) {
		return new Rating(1L,2L,movieId, 4);
	}

	@Override
	public Rating createMovieRating(Rating rating) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RatingResponse convertToRatingResponse(Rating rating) {
		RatingResponse ratingResponse = new RatingResponse(rating.getMovieId(),rating.getRating());
		return ratingResponse;
	}
	
	@Override
	public UserRatingResponse getUserRatings(String userId) {
		UserRatingResponse userRatings = new UserRatingResponse();
		userRatings.initData(userId);
		return userRatings;
	}
}
