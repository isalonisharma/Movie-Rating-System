package com.movieinfomicroservice.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.movieinfomicroservice.models.Movie;
import com.movieinfomicroservice.models.MovieSummary;
import com.movieinfomicroservice.services.MovieInfoService;

@Service
public class MovieInfoServiceImpl implements MovieInfoService {
	@Value("${api.key}")
	private String apiKey;

	@Autowired // consumer
	private RestTemplate restTemplate;

	@Override
	public Movie getMovie(String movieId) {
		// get movie info
		MovieSummary movieSummary = restTemplate.getForObject(
				"https://api.themoviedb.org/3/movie/" + movieId + "?api_key=" + apiKey, MovieSummary.class);

		return new Movie(movieId, movieSummary.getTitle(), movieSummary.getOverview());
	}

}
