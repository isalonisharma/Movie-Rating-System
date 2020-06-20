package com.moviecatalogmicroservice.services.impl;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.moviecatalogmicroservice.models.responses.RatingResponse;
import com.moviecatalogmicroservice.models.responses.UserRatingResponse;
import com.moviecatalogmicroservice.services.RatingDataService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Service
public class RatingDataServiceImpl implements RatingDataService {
	@Autowired // consumer
	private RestTemplate restTemplate;

	@HystrixCommand(
            fallbackMethod = "getFallbackUserRating",
            threadPoolKey = "ratingDataPool",
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "20"), // no of concurrent threads allowed
                    @HystrixProperty(name = "maxQueueSize", value = "10") // how many requests can be in queue
            })
	@Override
	public UserRatingResponse getUserRating(String userId) {
		// get all rated movie id rating's of user
		UserRatingResponse userRatingResponse = restTemplate.getForObject("http://rating-data-microservice/ratings/users/" + userId,
				UserRatingResponse.class);
		return userRatingResponse;
	}

	public UserRatingResponse getFallbackUserRating(String userId) {
		UserRatingResponse userRating = new UserRatingResponse();
		userRating.setUserId(userId);
		userRating.setListRatingResponse(Arrays.asList(new RatingResponse("0", 0)));
		return userRating;
	}
}
