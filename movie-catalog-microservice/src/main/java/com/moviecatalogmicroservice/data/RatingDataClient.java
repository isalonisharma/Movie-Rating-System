package com.moviecatalogmicroservice.data;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.moviecatalogmicroservice.models.responses.RatingDTO;
import com.moviecatalogmicroservice.models.responses.UserRating;

import feign.FeignException;
import feign.hystrix.FallbackFactory;

@FeignClient(name = "rating-data-microservice", fallbackFactory = RatingDataClientFallbackFactory.class)
public interface RatingDataClient {

	@GetMapping("users/{userId}/ratings")
	public UserRating getUserRating(@PathVariable Long userId);
}

@Component
class RatingDataClientFallbackFactory implements FallbackFactory<RatingDataClient> {

	@Override
	public RatingDataClient create(Throwable cause) {
		return new RatingDataClientFallback(cause);
	}
}

class RatingDataClientFallback implements RatingDataClient {
	Logger logger = LoggerFactory.getLogger(this.getClass());

	private final Throwable cause;

	public RatingDataClientFallback(Throwable cause) {
		this.cause = cause;
	}

	@Override
	public UserRating getUserRating(Long userId) {
		if (cause instanceof FeignException && ((FeignException) cause).status() == 404) {
			logger.error("404 error took place when getUserRating was called with userId: " + userId
					+ ". Error message: " + cause.getLocalizedMessage());
		} else {
			logger.error("Other error took place: " + cause.getLocalizedMessage());
		}
		return new UserRating(userId, new ArrayList<RatingDTO>());
	}
}