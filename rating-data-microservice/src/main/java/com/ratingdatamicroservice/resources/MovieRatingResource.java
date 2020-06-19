package com.ratingdatamicroservice.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ratingdatamicroservice.models.Rating;
import com.ratingdatamicroservice.services.MovieRatingService;

@RestController
@RequestMapping("/ratings/movies")
public class MovieRatingResource {

	@Autowired
	private MovieRatingService movieRatingService;

	@GetMapping(path = "/{movieId}")
	public Rating getMovieRating(@PathVariable("movieId") String movieId) {
		Rating rating = movieRatingService.getMovieRating(movieId);
		return rating;
	}
}
