package com.ratingdatamicroservice.services.impl;

import org.springframework.stereotype.Service;

import com.ratingdatamicroservice.models.UserRating;
import com.ratingdatamicroservice.services.UserRatingService;

@Service
public class UserRatingServiceImpl implements UserRatingService{
	
	@Override
	public UserRating getUserRatings(String userId) {
		UserRating userRatings = new UserRating();
		userRatings.initData(userId);
		return userRatings;
	}
	
}
