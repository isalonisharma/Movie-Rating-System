package com.movieinfomicroservice.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movieinfomicroservice.models.Movie;
import com.movieinfomicroservice.services.MovieInfoService;

@RestController
@RequestMapping("/movies")
public class MovieResource {

	@Autowired
	private MovieInfoService movieInfoService;

	@RequestMapping("/{movieId}")
	public Movie getMovie(@PathVariable("movieId") String movieId) {
		Movie movie = movieInfoService.getMovie(movieId);
		return movie;
	}
}
