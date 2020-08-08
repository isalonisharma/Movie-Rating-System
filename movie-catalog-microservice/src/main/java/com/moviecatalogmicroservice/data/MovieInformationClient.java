package com.moviecatalogmicroservice.data;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.moviecatalogmicroservice.models.Movie;

@FeignClient(name = "movie-information-microservice")
public interface MovieInformationClient {

	@GetMapping("/movies/{movieId}")
	public Movie getMovie(@PathVariable String movieId);
}