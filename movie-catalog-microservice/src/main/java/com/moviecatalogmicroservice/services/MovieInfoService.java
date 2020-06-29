package com.moviecatalogmicroservice.services;

import com.moviecatalogmicroservice.models.Movie;

public interface MovieInfoService {

	Movie getMovie(String movieId);
}
