package com.usermicroservice.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usermicroservice.dao.UserRoleDao;
import com.usermicroservice.entities.User;
import com.usermicroservice.entities.UserRole;
import com.usermicroservice.exceptions.UserNotFoundException;
import com.usermicroservice.services.UserRoleService;

@Service
public class UserRoleServiceImpl implements UserRoleService {
	@Autowired
	private UserRoleDao userRoleDao;

	@Override
	public void createUserRole(UserRole userRole) {
		userRoleDao.createUserRole(userRole);
	}

	@Override
	public void deleteUserRoleByUser(User user) throws UserNotFoundException {
		userRoleDao.deleteUserRoleByUser(user);
	}
}