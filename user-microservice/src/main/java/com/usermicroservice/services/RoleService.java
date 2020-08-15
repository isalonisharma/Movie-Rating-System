package com.usermicroservice.services;

import com.usermicroservice.entities.Role;

public interface RoleService {
	Role findByName(String name);
}
