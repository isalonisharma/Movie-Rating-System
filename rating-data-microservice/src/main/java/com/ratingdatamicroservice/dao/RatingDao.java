package com.ratingdatamicroservice.dao;

import com.ratingdatamicroservice.exceptions.RatingNotFoundException;
import com.ratingdatamicroservice.exceptions.UserNotFoundException;
import com.ratingdatamicroservice.models.Rating;
import com.ratingdatamicroservice.models.responses.RatingDTO;
import com.ratingdatamicroservice.models.responses.UserRating;

public interface RatingDao {
	Rating createRating(Rating rating);

	Rating getRatingById(Long ratingId) throws RatingNotFoundException;
	
	Rating getRatingByMovieId(String movieId) throws RatingNotFoundException;

	Rating updateRating(RatingDTO ratingDTO, Long ratingId) throws RatingNotFoundException;
	
	void deleteRating(Rating rating) throws RatingNotFoundException;

	UserRating getUserRatings(Long userId) throws UserNotFoundException;
}