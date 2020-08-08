package com.moviecatalogmicroservice.data;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.moviecatalogmicroservice.models.responses.UserRatingResponse;

@FeignClient(name = "rating-data-microservice")
public interface RatingDataClient {

	@GetMapping("users/{userId}/ratings")
	public UserRatingResponse getUserRating(@PathVariable String userId);
}