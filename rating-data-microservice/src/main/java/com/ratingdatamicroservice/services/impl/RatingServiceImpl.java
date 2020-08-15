package com.ratingdatamicroservice.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ratingdatamicroservice.dao.RatingDao;
import com.ratingdatamicroservice.dao.UserDao;
import com.ratingdatamicroservice.exceptions.RatingNotFoundException;
import com.ratingdatamicroservice.exceptions.UserNotFoundException;
import com.ratingdatamicroservice.models.Rating;
import com.ratingdatamicroservice.models.User;
import com.ratingdatamicroservice.models.responses.RatingDTO;
import com.ratingdatamicroservice.models.responses.UserRating;
import com.ratingdatamicroservice.services.RatingService;

@Service
public class RatingServiceImpl implements RatingService {

	@Autowired
	private RatingDao ratingDao;
	
	@Autowired 
	private UserDao userDao;
	
	@Override
	public Rating createRating(RatingDTO ratingDTO, Long userId) throws UserNotFoundException {
		User user = userDao.getUserById(userId);
		return ratingDao.createRating(new Rating(ratingDTO,user));
	}
	
	@Override
	public Rating getRatingByMovieId(String movieId) throws RatingNotFoundException {
		return ratingDao.getRatingByMovieId(movieId);
	}

	@Override
	public Rating updateRating(RatingDTO ratingDTO, Long ratingId) throws RatingNotFoundException {
		return ratingDao.updateRating(ratingDTO, ratingId);
	}
	
	@Override
	public RatingDTO convertToRatingResponse(Rating rating) {
		RatingDTO ratingDTO = new RatingDTO(rating.getMovieId(),rating.getRating());
		return ratingDTO;
	}
	
	@Override
	public UserRating getUserRatings(Long userId) throws UserNotFoundException {
		UserRating userRatings = ratingDao.getUserRatings(userId);
		return userRatings;
	}
}
