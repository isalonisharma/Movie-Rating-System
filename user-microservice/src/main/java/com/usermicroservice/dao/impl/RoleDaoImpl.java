package com.usermicroservice.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.usermicroservice.dao.RoleDao;
import com.usermicroservice.entities.Role;
import com.usermicroservice.repository.RoleRepository;

@Repository
public class RoleDaoImpl  implements RoleDao {
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public Role findByName(String name) {
		return roleRepository.findByName(name);
	}
}