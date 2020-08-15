package com.usermicroservice.dao;

import com.usermicroservice.entities.User;
import com.usermicroservice.exceptions.UserNotFoundException;
import com.usermicroservice.models.DTO.UserDTO;
import com.usermicroservice.models.requests.UserRequest;

public interface UserDao {
	User createUser(UserRequest userRequest);

	User getUserById(Long userId) throws UserNotFoundException;

	UserDTO updateUser(UserRequest userRequest, Long id) throws UserNotFoundException;

	void deleteUser(User user) throws UserNotFoundException;

	UserDTO getUserByUsername(String username) throws UserNotFoundException;
}