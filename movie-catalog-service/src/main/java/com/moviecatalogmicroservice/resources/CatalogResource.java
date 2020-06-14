package com.moviecatalogmicroservice.resources;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.moviecatalogmicroservice.models.Catalog;
import com.moviecatalogmicroservice.models.Movie;
import com.moviecatalogmicroservice.models.Rating;
import com.moviecatalogmicroservice.models.UserRating;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/catalog")
public class CatalogResource {

	@Autowired // consumer
	private RestTemplate restTemplate;

	@RequestMapping("/{userId}")
	@HystrixCommand(fallbackMethod = "getFallbackCatalog")
	public List<Catalog> getCatalogItem(@PathVariable("userId") String userId) {

		// 1. get all rated movie id's
		UserRating userRating = restTemplate.getForObject("http://rating-data-microservice/ratings/user/" + userId,
				UserRating.class);

		List<Rating> ratings = userRating.getRatings();

		return ratings.stream().map(rating -> {

			// 2. for each movie id, call movie info service to get movie details
			Movie movie = restTemplate.getForObject("http://movie-info-microservice/movie/" + rating.getMovieId(),
					Movie.class);

			// 3. put them all together
			return new Catalog(movie.getName(), movie.getDescription(), rating.getRating());

		}).collect(Collectors.toList());
	}
	
	public List<Catalog> getFallbackCatalog(@PathVariable("userId") String userId) {
		return Arrays.asList(new Catalog("No Movie","",0));
	}
}
