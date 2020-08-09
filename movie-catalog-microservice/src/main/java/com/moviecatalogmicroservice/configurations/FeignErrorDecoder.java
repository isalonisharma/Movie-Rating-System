package com.moviecatalogmicroservice.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.moviecatalogmicroservice.exceptions.MicroservicesException;

import feign.Response;
import feign.codec.ErrorDecoder;

@Component
public class FeignErrorDecoder implements ErrorDecoder {

	Environment environment;

	@Autowired
	public FeignErrorDecoder(Environment environment) {
		this.environment = environment;
	}

	@Override
	public Exception decode(String methodKey, Response response) {
		switch (response.status()) {
			case 400:
				// Do something
				// return new BadRequestException();
				break;
			case 404: {
				if (methodKey.contains("MovieInformationClient#getMovie(String)")) {
					return new MicroservicesException(environment.getProperty("movie.information.microservice.exceptions.movie-not-found"));
				}
				if (methodKey.contains("RatingDataClient#getUserRating(String)")) {
					return new MicroservicesException(environment.getProperty("rating.data.microservice.exceptions.user-rating-not-found"));
				}
				break;
			}
			default:
				return new Exception(response.reason());
		}
		return null;
	}
}