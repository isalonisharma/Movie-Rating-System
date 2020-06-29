package com.moviecatalogmicroservice.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.moviecatalogmicroservice.models.responses.UserRatingResponse;
import com.moviecatalogmicroservice.services.RatingDataService;

@Service
public class RatingDataServiceImpl implements RatingDataService {
	@Autowired // consumer
	private RestTemplate restTemplate;

	@Override
	public UserRatingResponse getUserRating(String userId) {
		// get all rated movie id rating's of user
		UserRatingResponse userRatingResponse = restTemplate.getForObject(
				"http://localhost:8081/rating-data-microservice/ratings/users/" + userId, UserRatingResponse.class);
		return userRatingResponse;
	}
}
