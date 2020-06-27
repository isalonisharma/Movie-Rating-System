package com.usermicroservice.dao;

import com.usermicroservice.exceptions.UserNotFoundException;
import com.usermicroservice.models.DTO.UserDTO;
import com.usermicroservice.models.requests.CreateUserRequest;

public interface UserDao {
	UserDTO createUser(CreateUserRequest createUserRequest);

	UserDTO getUserByEmail(String email) throws UserNotFoundException;

	UserDTO getUserById(Long id) throws UserNotFoundException;
}
