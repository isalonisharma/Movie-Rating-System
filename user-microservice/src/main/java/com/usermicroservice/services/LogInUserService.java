package com.usermicroservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.usermicroservice.models.LogInUser;
import com.usermicroservice.models.User;
import com.usermicroservice.models.UserRole;
import com.usermicroservice.repository.UserRepository;
import com.usermicroservice.repository.UserRoleRepository;

@Service
public class LogInUserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
	private UserRoleRepository userRoleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	User user = userRepository.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User 404 Not Found");
		}
		
        UserRole userRole = userRoleRepository.findByuser(user);
        return new LogInUser(user, userRole);
    }
}