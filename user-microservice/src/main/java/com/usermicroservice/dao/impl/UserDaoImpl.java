package com.usermicroservice.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.usermicroservice.dao.UserDao;
import com.usermicroservice.entities.User;
import com.usermicroservice.exceptions.UserNotFoundException;
import com.usermicroservice.models.DTO.UserDTO;
import com.usermicroservice.models.requests.CreateUserRequest;
import com.usermicroservice.repository.UserRepository;

@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	UserRepository userRepository;

	BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

	@Override
	public UserDTO createUser(CreateUserRequest createUserRequest) {
		User user = new User(createUserRequest.getFirstName(), createUserRequest.getLastName(),
				createUserRequest.getUsername(), bCryptPasswordEncoder.encode(createUserRequest.getPassword()), true);
		User saveduser = userRepository.save(user);
		return new UserDTO(saveduser);
	}

	@Override
	public UserDTO getUserById(Long id) throws UserNotFoundException {
		User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found :: " + id));
		return new UserDTO(user);
	}

	@Override
	public UserDTO getUserByUsername(String username) throws UserNotFoundException {
		User user = userRepository.findByUsername(username);
		if (user == null) {
			throw new UserNotFoundException("User not found :: " + username);
		}
		return new UserDTO(user);
	}
}