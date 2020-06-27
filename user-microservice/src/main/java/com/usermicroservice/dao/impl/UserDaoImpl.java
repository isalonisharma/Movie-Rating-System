package com.usermicroservice.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.usermicroservice.dao.UserDao;
import com.usermicroservice.exceptions.UserNotFoundException;
import com.usermicroservice.models.User;
import com.usermicroservice.models.DTO.UserDTO;
import com.usermicroservice.models.requests.CreateUserRequest;
import com.usermicroservice.repository.UserRepository;

@Repository
public class UserDaoImpl implements UserDao{
	@Autowired
	UserRepository userRepository;

	BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

	@Override
	public UserDTO createUser(CreateUserRequest createUserRequest) {
		User user = new User(createUserRequest.getFirstName(), createUserRequest.getLastName(),
				createUserRequest.getEmail(), bCryptPasswordEncoder.encode(createUserRequest.getPassword()));
		System.out.println(user.toString());
		User saveduser = userRepository.save(user);
		System.out.println(saveduser.toString());
		return new UserDTO(saveduser);
	}

	@Override
	public UserDTO getUserByEmail(String email) throws UserNotFoundException {
		User user = userRepository.findByEmail(email);
		if (user == null) {
			throw new UserNotFoundException("User not found :: " + email);
		}
		return new UserDTO(user);
	}

	@Override
	public UserDTO getUserById(Long id) throws UserNotFoundException {
		User user = userRepository.findById(id)
				.orElseThrow(() -> new UserNotFoundException("User not found :: " + id));
		return new UserDTO(user);
	}
}
