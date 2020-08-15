package com.usermicroservice.services;

import com.usermicroservice.exceptions.UserNotFoundException;
import com.usermicroservice.models.DTO.UserDTO;
import com.usermicroservice.models.requests.UserRequest;

public interface UserService {
	UserDTO createUser(UserRequest userRequest);

	UserDTO getUserById(Long userId) throws UserNotFoundException;

	UserDTO updateUser(UserRequest userRequest, Long userId) throws UserNotFoundException;

	void deleteUser(Long userId) throws UserNotFoundException;

	UserDTO getUserByUsername(String username) throws UserNotFoundException;
}
