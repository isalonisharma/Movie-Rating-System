package com.ratingdatamicroservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ratingdatamicroservice.exceptions.RatingNotFoundException;
import com.ratingdatamicroservice.exceptions.UserNotFoundException;
import com.ratingdatamicroservice.models.Rating;
import com.ratingdatamicroservice.models.responses.RatingDTO;
import com.ratingdatamicroservice.models.responses.UserRating;
import com.ratingdatamicroservice.services.RatingService;

@RestController
@RequestMapping("/users/{userId}/ratings")
public class RatingController {

	@Autowired
	private RatingService ratingService;

	@PostMapping
	public RatingDTO createRating(@PathVariable("userId") Long userId,
			@RequestBody RatingDTO ratingDTO) throws UserNotFoundException {
		Rating saveRating = ratingService.createRating(ratingDTO,userId);
		RatingDTO ratingResponse = ratingService.convertToRatingResponse(saveRating);
		return ratingResponse;
	}

	@GetMapping(path = "/movies/{movieId}")
	public RatingDTO getRatingByMovieId(@PathVariable("movieId") String movieId) throws RatingNotFoundException {
		Rating rating = ratingService.getRatingByMovieId(movieId);
		RatingDTO ratingDTO = ratingService.convertToRatingResponse(rating);
		return ratingDTO;
	}

	@PutMapping(path = "/{ratingId}")
	public RatingDTO updateRating(@PathVariable("ratingId") Long ratingId, @RequestBody RatingDTO ratingDTO)
			throws RatingNotFoundException {
		Rating saveRating = ratingService.updateRating(ratingDTO, ratingId);
		RatingDTO ratingResponse = ratingService.convertToRatingResponse(saveRating);
		return ratingResponse;
	}

	@GetMapping
	public UserRating getUserRatings(@PathVariable("userId") Long userId) throws UserNotFoundException {
		UserRating userRating = ratingService.getUserRatings(userId);
		return userRating;
	}
}
