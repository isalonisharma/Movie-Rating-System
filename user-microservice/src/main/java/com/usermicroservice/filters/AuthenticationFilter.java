package com.usermicroservice.filters;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.usermicroservice.exceptions.UserNotFoundException;
import com.usermicroservice.models.DTO.AuthenticationUser;
import com.usermicroservice.models.DTO.UserDTO;
import com.usermicroservice.models.requests.AuthenticationRequest;
import com.usermicroservice.services.UserService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	private UserService userService;

	private Environment environment;

	public AuthenticationFilter(AuthenticationManager authenticationManager, Environment environment,
			UserService userService) {
		this.environment = environment;
		this.userService = userService;
		super.setAuthenticationManager(authenticationManager);
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws AuthenticationException {
		try {
			AuthenticationRequest authenticationRequest = new ObjectMapper()
					.readValue(httpServletRequest.getInputStream(), AuthenticationRequest.class);

			return getAuthenticationManager().authenticate(new UsernamePasswordAuthenticationToken(
					authenticationRequest.getUsername(), authenticationRequest.getPassword(), new ArrayList<>()));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse, FilterChain chain, Authentication auth)
			throws IOException, ServletException {
		String username = ((AuthenticationUser) auth.getPrincipal()).getUsername();
		Date tokenExpiration = new Date(
				System.currentTimeMillis() + Long.parseLong(environment.getProperty("token.expiration_time")));
		System.err.println("token_expiration_time: " + environment.getProperty("token.expiration_time"));
		String tokenSecret = environment.getProperty("token.secret");
		try {
			UserDTO userDTO = userService.getUserByUsername(username);
			String token = Jwts.builder().setSubject(userDTO.getId().toString()).setExpiration(tokenExpiration)
					.signWith(SignatureAlgorithm.HS512, tokenSecret).compact();
			httpServletResponse.addHeader("token", token);
			httpServletResponse.addHeader("id", userDTO.getId().toString());
		} catch (UserNotFoundException e) {
			e.printStackTrace();
		}
	}
}