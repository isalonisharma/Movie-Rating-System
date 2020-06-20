package com.ratingdatamicroservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ratingdatamicroservice.models.Rating;
import com.ratingdatamicroservice.models.responses.RatingResponse;
import com.ratingdatamicroservice.models.responses.UserRatingResponse;
import com.ratingdatamicroservice.services.RatingService;

@RestController
@RequestMapping("/ratings")
public class RatingController {

	@Autowired
	private RatingService ratingService;

	@GetMapping(path = "/movies/{movieId}")
	public RatingResponse getMovieRating(@PathVariable("movieId") String movieId) {
		Rating rating = ratingService.getMovieRating(movieId);
		RatingResponse ratingResponse = ratingService.convertToRatingResponse(rating);
		return ratingResponse;
	}
	
	@PostMapping(path = "/movies")
	public RatingResponse createMovieRating(@RequestBody Rating rating) {
		Rating saveRating = ratingService.createMovieRating(rating);
		RatingResponse ratingResponse = ratingService.convertToRatingResponse(saveRating);
		return ratingResponse;
	}
	
	@PostMapping(path = "/movies/{movieId}")
	public RatingResponse updateMovieRating(@RequestBody Rating rating) {
		Rating saveRating = ratingService.updateMovieRating(rating);
		RatingResponse ratingResponse = ratingService.convertToRatingResponse(saveRating);
		return ratingResponse;
	}
	
	
	@GetMapping(path = "users/{userId}")
	public UserRatingResponse getUserRatings(@PathVariable("userId") String userId) {
		UserRatingResponse userRatingResponse = ratingService.getUserRatings(userId);
		return userRatingResponse;
	}
}
