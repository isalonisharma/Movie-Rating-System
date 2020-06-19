package com.ratingdatamicroservice.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ratingdatamicroservice.models.UserRating;
import com.ratingdatamicroservice.services.RatingDataService;

@RestController
@RequestMapping("/ratings/users")
public class UserRatingResource {

	@Autowired
	private RatingDataService ratingDataService;

	@GetMapping(path = "/{userId}")
	public UserRating getUserRatings(@PathVariable("userId") String userId) {
		UserRating userRatings = ratingDataService.getUserRatings(userId);
		return userRatings;
	}
}
