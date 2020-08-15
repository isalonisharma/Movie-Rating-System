package com.usermicroservice.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usermicroservice.dao.UserDao;
import com.usermicroservice.entities.Role;
import com.usermicroservice.entities.User;
import com.usermicroservice.entities.UserRole;
import com.usermicroservice.exceptions.UserNotFoundException;
import com.usermicroservice.models.DTO.UserDTO;
import com.usermicroservice.models.requests.UserRequest;
import com.usermicroservice.services.RoleService;
import com.usermicroservice.services.UserRoleService;
import com.usermicroservice.services.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRoleService userRoleService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private UserDao userDao;

	@Override
	public UserDTO createUser(UserRequest userRequest) {
		User user = userDao.createUser(userRequest);
		Role role = roleService.findByName("ROLE_USER");
		userRoleService.createUserRole(new UserRole(user,role));
		return new UserDTO(user);
	}

	@Override
	public UserDTO getUserById(Long userId) throws UserNotFoundException {
		User user = userDao.getUserById(userId);
		return new UserDTO(user);
	}

	@Override
	public UserDTO updateUser(UserRequest userRequest, Long userId) throws UserNotFoundException {
		return userDao.updateUser(userRequest, userId);
	}

	@Override
	public void deleteUser(Long userId) throws UserNotFoundException {
		User user = userDao.getUserById(userId);
		userRoleService.deleteUserRoleByUser(user);
		userDao.deleteUser(user);
	}
	
	@Override
	public UserDTO getUserByUsername(String username) throws UserNotFoundException {
		return userDao.getUserByUsername(username);
	}
}