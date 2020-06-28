package com.usermicroservice.services;

import com.usermicroservice.exceptions.UserNotFoundException;
import com.usermicroservice.models.DTO.UserDTO;
import com.usermicroservice.models.requests.CreateUserRequest;

public interface UserService {
	UserDTO createUser(CreateUserRequest createUserRequest);
	UserDTO getUserById(Long id) throws UserNotFoundException;
	UserDTO getUserByUsername(String username) throws UserNotFoundException;
}
