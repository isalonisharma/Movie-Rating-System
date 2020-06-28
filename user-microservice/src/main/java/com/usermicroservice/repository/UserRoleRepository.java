package com.usermicroservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usermicroservice.models.User;
import com.usermicroservice.models.UserRole;

public interface UserRoleRepository  extends JpaRepository<UserRole, Long> {
	UserRole findByuser(User user);
}
