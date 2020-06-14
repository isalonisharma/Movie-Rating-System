package com.moviecatalogmicroservice.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moviecatalogmicroservice.models.Catalog;
import com.moviecatalogmicroservice.models.Movie;
import com.moviecatalogmicroservice.models.Rating;
import com.moviecatalogmicroservice.models.UserRating;
import com.moviecatalogmicroservice.services.CatalogService;
import com.moviecatalogmicroservice.services.MovieInfoService;
import com.moviecatalogmicroservice.services.RatingDataService;

@Service
public class CatalogServiceImpl implements CatalogService {

	@Autowired
	private MovieInfoService movieInfoService;

	@Autowired
	private RatingDataService ratingDataService;

	@Override
	public List<Catalog> getCatalogItem(String userId) {
		// 1. get all rated movie id's
		UserRating userRating = ratingDataService.getUserRating(userId);

		List<Rating> ratings = userRating.getRatings();

		return ratings.stream().map(rating -> {

			String movieId = rating.getMovieId();

			// 2. for each movie id, call movie info service to get movie details
			Movie movie = movieInfoService.getMovie(movieId);

			// 3. put them all together
			return new Catalog(movieId, movie.getName(), movie.getDescription(), rating.getRating());

		}).collect(Collectors.toList());
	}
}
