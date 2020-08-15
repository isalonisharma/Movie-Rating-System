package com.ratingdatamicroservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ratingdatamicroservice.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
}