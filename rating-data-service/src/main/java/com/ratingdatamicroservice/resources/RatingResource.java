package com.ratingdatamicroservice.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ratingdatamicroservice.models.Rating;
import com.ratingdatamicroservice.models.UserRating;
import com.ratingdatamicroservice.services.RatingDataService;

@RestController
@RequestMapping("/ratings")
public class RatingResource {

	@Autowired
	private RatingDataService ratingDataService;

	@RequestMapping("movie/{movieId}")
	public Rating getMovieRating(@PathVariable("movieId") String movieId) {
		Rating rating = ratingDataService.getMovieRating(movieId);
		return rating;
	}

	@RequestMapping("user/{userId}")
	public UserRating getUserRatings(@PathVariable("userId") String userId) {
		UserRating userRatings = ratingDataService.getUserRatings(userId);
		return userRatings;
	}
}
