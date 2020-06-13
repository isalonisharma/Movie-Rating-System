package com.moviecatalogservice.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.moviecatalogservice.models.Catalog;
import com.moviecatalogservice.models.Movie;
import com.moviecatalogservice.models.Rating;
import com.moviecatalogservice.models.UserRating;

@RestController
@RequestMapping("/catalog")
public class CatalogResource {

	@Autowired // consumer
	private RestTemplate restTemplate;

	@RequestMapping("/{userId}")
	public List<Catalog> getCatalogItem(@PathVariable("userId") String userId) {

		// 1. get all rated movie id's
		UserRating userRating = restTemplate.getForObject("http://rating-data-service/ratings/users/" + userId,
				UserRating.class);

		List<Rating> ratings = userRating.getRatings();
		
		return ratings.stream().map(rating -> {
			
			// 2. for each movie id, call movie info service to get movie details
			Movie movie = restTemplate.getForObject("http://movie-info-service/movies/" + rating.getId(), Movie.class);
			
			// 3. put them all together
			return new Catalog(movie.getName(), movie.getDescription(), rating.getRating());
			
		}).collect(Collectors.toList());
	}
}
