package com.ratingdatamicroservice.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ratingdatamicroservice.dao.UserDao;
import com.ratingdatamicroservice.exceptions.UserNotFoundException;
import com.ratingdatamicroservice.models.User;
import com.ratingdatamicroservice.repository.UserRepository;

@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	private UserRepository userRepository;

	@Override
	public User getUserById(Long id) throws UserNotFoundException {
		User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found :: " + id));
		return user;
	}
}
