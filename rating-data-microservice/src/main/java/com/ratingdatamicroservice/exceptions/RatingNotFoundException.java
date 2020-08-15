package com.ratingdatamicroservice.exceptions;

/**
 * Class: RatingNotFoundException
 * Use: this exception is used to notify user that rating not found of a
 * particular id
 */
public class RatingNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;

	public RatingNotFoundException(String message) {
		super(message);
	}

	public RatingNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
}
