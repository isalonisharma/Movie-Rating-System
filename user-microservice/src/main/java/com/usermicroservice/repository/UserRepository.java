package com.usermicroservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usermicroservice.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername(String username);
}
