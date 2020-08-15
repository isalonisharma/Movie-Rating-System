package com.usermicroservice.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.usermicroservice.dao.UserRoleDao;
import com.usermicroservice.entities.User;
import com.usermicroservice.entities.UserRole;
import com.usermicroservice.exceptions.UserNotFoundException;
import com.usermicroservice.repository.UserRoleRepository;

@Repository
public class UserRoleDaoImpl implements UserRoleDao {
	@Autowired
	private UserRoleRepository userRoleRepository;

	@Override
	public void createUserRole(UserRole userRole) {
		userRoleRepository.save(userRole);
	}

	@Override
	public void deleteUserRoleByUser(User user) throws UserNotFoundException {
		UserRole userRole = userRoleRepository.findByuser(user);
		userRoleRepository.delete(userRole);
	}
}