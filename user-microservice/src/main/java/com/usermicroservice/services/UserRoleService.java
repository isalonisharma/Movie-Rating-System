package com.usermicroservice.services;

import com.usermicroservice.entities.User;
import com.usermicroservice.entities.UserRole;
import com.usermicroservice.exceptions.UserNotFoundException;

public interface UserRoleService {
	void createUserRole(UserRole userRole);

	void deleteUserRoleByUser(User user) throws UserNotFoundException;
}
