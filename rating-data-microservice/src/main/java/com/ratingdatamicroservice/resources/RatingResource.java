package com.ratingdatamicroservice.resources;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ratingdatamicroservice.models.Rating;
import com.ratingdatamicroservice.models.response.RatingResponse;
import com.ratingdatamicroservice.models.response.UserRatingResponse;
import com.ratingdatamicroservice.services.RatingService;

@RestController
@RequestMapping("/ratings")
public class RatingResource {

	@Autowired
	private RatingService ratingService;

	@GetMapping(path = "/movies/{movieId}")
	public RatingResponse getMovieRating(@PathVariable("movieId") String movieId) {
		Rating rating = ratingService.getMovieRating(movieId);
		RatingResponse ratingResponse = ratingService.convertToRatingResponse(rating);
		return ratingResponse;
	}
	
	@PostMapping(path = "/movies")
	public RatingResponse createMovieRating(@Valid @RequestBody Rating rating) {
		Rating saveRating = ratingService.createMovieRating(rating);
		RatingResponse ratingResponse = ratingService.convertToRatingResponse(saveRating);
		return ratingResponse;
	}
	
	@PostMapping(path = "/movies/{movieId}")
	public RatingResponse updateMovieRating(@Valid @RequestBody Rating rating) {
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
