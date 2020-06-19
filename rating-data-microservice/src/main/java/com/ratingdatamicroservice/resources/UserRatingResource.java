package com.ratingdatamicroservice.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ratingdatamicroservice.models.UserRating;
import com.ratingdatamicroservice.services.UserRatingService;

@RestController
@RequestMapping("/ratings/users")
public class UserRatingResource {

	@Autowired
	private UserRatingService userRatingService;

	@GetMapping(path = "/{userId}")
	public UserRating getUserRatings(@PathVariable("userId") String userId) {
		UserRating userRatings = userRatingService.getUserRatings(userId);
		return userRatings;
	}
}
