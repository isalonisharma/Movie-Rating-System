package com.usermicroservice.dao;

import com.usermicroservice.entities.User;
import com.usermicroservice.entities.UserRole;
import com.usermicroservice.exceptions.UserNotFoundException;

public interface UserRoleDao {
	void createUserRole(UserRole userRole);

	void deleteUserRoleByUser(User user) throws UserNotFoundException;
}