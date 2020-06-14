package com.moviecatalogmicroservice.services.impl;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.moviecatalogmicroservice.models.Rating;
import com.moviecatalogmicroservice.models.UserRating;
import com.moviecatalogmicroservice.services.RatingDataService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class RatingDataServiceImpl implements RatingDataService {
	@Autowired // consumer
	private RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "getFallbackUserRating")
	@Override
	public UserRating getUserRating(String userId) {
		// get all rated movie id rating's of user
		UserRating userRating = restTemplate.getForObject("http://rating-data-microservice/ratings/user/" + userId,
				UserRating.class);
		return userRating;
	}

	public UserRating getFallbackUserRating(String userId) {
		UserRating userRating = new UserRating();
		userRating.setUserId(userId);
		userRating.setRatings(Arrays.asList(new Rating(1L, "0", 0)));
		return userRating;
	}
}