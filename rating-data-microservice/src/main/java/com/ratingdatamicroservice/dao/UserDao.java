package com.ratingdatamicroservice.dao;

import com.ratingdatamicroservice.exceptions.UserNotFoundException;
import com.ratingdatamicroservice.models.User;

public interface UserDao {
	User getUserById(Long userId) throws UserNotFoundException;	
}
