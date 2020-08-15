package com.usermicroservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.usermicroservice.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	Role findByName(String name);
}
