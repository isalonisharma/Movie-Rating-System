package com.usermicroservice.models.DTO;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.usermicroservice.entities.User;
import com.usermicroservice.entities.UserRole;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class AuthenticationUser implements UserDetails {
	
	private static final long serialVersionUID = 3782145143988662569L;
	
	private String userName;
    private String password;
    private boolean active;
    private List<GrantedAuthority> authorities;

    public AuthenticationUser(User user,UserRole userRole) {
        this.userName = user.getUsername();
        this.password = user.getPassword();
        this.active = user.isActive();
        this.authorities = Arrays.stream(userRole.getRole().getName().split(","))
                    .map(SimpleGrantedAuthority::new)
                    .collect(Collectors.toList());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return active;
    }
}