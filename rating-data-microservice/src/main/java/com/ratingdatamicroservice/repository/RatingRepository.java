package com.ratingdatamicroservice.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.ratingdatamicroservice.models.Rating;
import com.ratingdatamicroservice.models.User;

public interface RatingRepository extends JpaRepository<Rating, Long> {
	Rating findByMovieId(String movieId);
	
	List<Rating> findByUser(User user);
}