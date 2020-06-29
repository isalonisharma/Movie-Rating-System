package com.moviecatalogmicroservice.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.moviecatalogmicroservice.models.Movie;
import com.moviecatalogmicroservice.services.MovieInfoService;

@Service
public class MovieInfoServiceImpl implements MovieInfoService {

	@Autowired // consumer
	private RestTemplate restTemplate;

	@Override
	public Movie getMovie(String movieId) {
		// for movie id, call movie info service to get movie details
		Movie movie = restTemplate
				.getForObject("http://localhost:8081/movie-information-microservice/movies/" + movieId, Movie.class);
		return movie;
	}
}