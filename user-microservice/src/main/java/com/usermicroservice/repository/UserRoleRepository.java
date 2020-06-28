package com.usermicroservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usermicroservice.entities.User;
import com.usermicroservice.entities.UserRole;

public interface UserRoleRepository  extends JpaRepository<UserRole, Long> {
	UserRole findByuser(User user);
}