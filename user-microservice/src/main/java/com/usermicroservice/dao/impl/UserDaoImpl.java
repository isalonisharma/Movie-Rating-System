package com.usermicroservice.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.usermicroservice.dao.UserDao;
import com.usermicroservice.entities.User;
import com.usermicroservice.exceptions.UserNotFoundException;
import com.usermicroservice.models.DTO.UserDTO;
import com.usermicroservice.models.requests.UserRequest;
import com.usermicroservice.repository.UserRepository;

@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	private UserRepository userRepository;

	BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

	@Override
	public User createUser(UserRequest userRequest) {
		User user = new User(userRequest.getFirstName(), userRequest.getLastName(),
				userRequest.getUsername(), bCryptPasswordEncoder.encode(userRequest.getPassword()), true);
		User saveduser = userRepository.save(user);
		return saveduser;
	}

	@Override
	public User getUserById(Long id) throws UserNotFoundException {
		User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found :: " + id));
		return user;
	}
	
	@Override
	public UserDTO updateUser(UserRequest userRequest, Long id) throws UserNotFoundException {
		User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found :: " + id));
		user.setFirstName(userRequest.getFirstName());
		user.setLastName(userRequest.getLastName());
		user.setPassword(bCryptPasswordEncoder.encode(userRequest.getPassword()));
		User updatedUser = userRepository.save(user);
		return new UserDTO(updatedUser);
	}

	@Override
	public void deleteUser(User user) throws UserNotFoundException {
		userRepository.delete(user);
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