package com.usermicroservice.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usermicroservice.dao.RoleDao;
import com.usermicroservice.entities.Role;
import com.usermicroservice.services.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleDao roleDao;
	
	@Override
	public Role findByName(String name) {
		return roleDao.findByName(name);
	}
}