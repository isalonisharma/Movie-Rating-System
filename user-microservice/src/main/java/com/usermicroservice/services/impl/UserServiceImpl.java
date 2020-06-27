package com.usermicroservice.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usermicroservice.dao.UserDao;
import com.usermicroservice.exceptions.UserNotFoundException;
import com.usermicroservice.models.DTO.UserDTO;
import com.usermicroservice.models.requests.CreateUserRequest;
import com.usermicroservice.services.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserDao userDao;

	@Override
	public UserDTO createUser(CreateUserRequest createUserRequest) {
		return userDao.createUser(createUserRequest);
	}

	@Override
	public UserDTO getUserByEmail(String email) throws UserNotFoundException {
		return userDao.getUserByEmail(email);
	}

	@Override
	public UserDTO getUserById(Long id) throws UserNotFoundException {
		return userDao.getUserById(id);
	}
}