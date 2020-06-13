package com.movieinfoservice.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.movieinfoservice.models.Movie;
import com.movieinfoservice.models.MovieSummary;

@RestController
@RequestMapping("/movie")
public class MovieResource {

	@Value("${api.key}")
	private String apiKey;

	@Autowired // consumer
	private RestTemplate restTemplate;

	@RequestMapping("/{movieId}")
	public Movie getMovie(@PathVariable("movieId") String movieId) {
		// get movie info
		MovieSummary movieSummary = restTemplate.getForObject(
				"https://api.themoviedb.org/3/movie/" + movieId + "?api_key=" + apiKey,
				MovieSummary.class);
				
		return new Movie(movieId, movieSummary.getTitle(),movieSummary.getOverview());
	}
}
