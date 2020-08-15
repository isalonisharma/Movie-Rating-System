package com.usermicroservice.dao;

import com.usermicroservice.entities.Role;

public interface RoleDao {
	Role findByName(String name);
}
