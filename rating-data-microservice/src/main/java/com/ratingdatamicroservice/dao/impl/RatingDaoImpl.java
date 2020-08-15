package com.ratingdatamicroservice.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ratingdatamicroservice.dao.RatingDao;
import com.ratingdatamicroservice.dao.UserDao;
import com.ratingdatamicroservice.exceptions.RatingNotFoundException;
import com.ratingdatamicroservice.exceptions.UserNotFoundException;
import com.ratingdatamicroservice.models.Rating;
import com.ratingdatamicroservice.models.User;
import com.ratingdatamicroservice.models.responses.RatingDTO;
import com.ratingdatamicroservice.models.responses.UserRating;
import com.ratingdatamicroservice.repository.RatingRepository;
import com.ratingdatamicroservice.repository.UserRepository;

@Repository
public class RatingDaoImpl implements RatingDao {

	@Autowired
	private RatingRepository ratingRepository;

	@Autowired
	private UserDao userDao;

	@Override
	public Rating createRating(Rating rating) {
		return ratingRepository.save(rating);
	}

	@Override
	public Rating getRatingById(Long ratingId) throws RatingNotFoundException {
		return ratingRepository.findById(ratingId)
				.orElseThrow(() -> new RatingNotFoundException("Rating not found :: " + ratingId));
	}

	@Override
	public Rating updateRating(RatingDTO ratingDTO, Long ratingId) throws RatingNotFoundException {
		Rating rating = getRatingById(ratingId);
		rating.setRating(ratingDTO.getRating());
		return ratingRepository.save(rating);
	}

	@Override
	public void deleteRating(Rating rating) throws RatingNotFoundException {
		ratingRepository.delete(rating);
	}

	@Override
	public Rating getRatingByMovieId(String movieId) throws RatingNotFoundException {
		Rating rating = ratingRepository.findByMovieId(movieId);
		if (rating == null) {
			new RatingNotFoundException("Rating for Movie Id not found :: " + movieId);
		}
		return rating;
	}

	@Override
	public UserRating getUserRatings(Long userId) throws UserNotFoundException {
		UserRating userRating = new UserRating();
		List<RatingDTO> listRatingDTO = new ArrayList<RatingDTO>();
		User user = userDao.getUserById(userId);
		for (Rating rating : ratingRepository.findByUser(user)) {
			listRatingDTO.add(new RatingDTO(rating.getMovieId(), rating.getRating()));
		}
		userRating.setUserId(userId);
		userRating.setListRatingDTO(listRatingDTO);
		return userRating;
	}
}