package com.moviecatalogmicroservice.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.moviecatalogmicroservice.models.Movie;

import feign.FeignException;
import feign.hystrix.FallbackFactory;

@FeignClient(name = "movie-information-microservice", fallbackFactory = MovieInformationClientFallbackFactory.class)
public interface MovieInformationClient {

	@GetMapping("/movies/{movieId}")
	public Movie getMovie(@PathVariable String movieId);
}

@Component
class MovieInformationClientFallbackFactory implements FallbackFactory<MovieInformationClient> {

	@Override
	public MovieInformationClient create(Throwable cause) {
		return new MovieInformationClientFallback(cause);
	}
}

class MovieInformationClientFallback implements MovieInformationClient {
	Logger logger = LoggerFactory.getLogger(this.getClass());

	private final Throwable cause;

	public MovieInformationClientFallback(Throwable cause) {
		this.cause = cause;
	}

	@Override
	public Movie getMovie(String movieId) {
		if (cause instanceof FeignException && ((FeignException) cause).status() == 404) {
			logger.error("404 error took place when getMovie was called with movieId: " + movieId + ". Error message: "
					+ cause.getLocalizedMessage());
		} else {
			logger.error("Other error took place: " + cause.getLocalizedMessage());
		}
		return new Movie(movieId, "Movie name not found", "Description not found");
	}
}