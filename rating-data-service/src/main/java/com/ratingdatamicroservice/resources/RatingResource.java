package com.ratingdatamicroservice.resources;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ratingdatamicroservice.models.Rating;
import com.ratingdatamicroservice.models.UserRating;

@RestController
@RequestMapping("/ratings")
public class RatingResource {
	
	@RequestMapping("movie/{movieId}")
    public Rating getMovieRating(@PathVariable("movieId") String movieId) {
        return new Rating(1L,movieId, 4);
	}
	
	@RequestMapping("user/{userId}")
    public UserRating getUserRatings(@PathVariable("userId") String userId) {
		UserRating userRatings = new UserRating();
        userRatings.initData(userId);
        return userRatings;
	}
}
