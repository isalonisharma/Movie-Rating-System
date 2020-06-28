package com.zuulapigateway.filters;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import io.jsonwebtoken.Jwts;

public class AuthorizationFilter extends BasicAuthenticationFilter {

	Environment environment;

	public AuthorizationFilter(AuthenticationManager authenticationManager, Environment environment) {
		super(authenticationManager);
		this.environment = environment;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
			FilterChain filterChain) throws IOException, ServletException {
		
		String authorizationHeader = httpServletRequest
				.getHeader(environment.getProperty("authorization.token.header.name"));
		
		if (authorizationHeader == null
				|| !authorizationHeader.startsWith(environment.getProperty("authorization.token.header.prefix"))) {
			filterChain.doFilter(httpServletRequest, httpServletResponse);
			return;
		}
		
		UsernamePasswordAuthenticationToken authentication = getAuthentication(httpServletRequest);
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		filterChain.doFilter(httpServletRequest, httpServletResponse);
	}

	private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest httpServletRequest) {
		
		String authorizationHeader = httpServletRequest
				.getHeader(environment.getProperty("authorization.token.header.name"));
		
		if (authorizationHeader == null) {
			return null;
		}
		
		String token = authorizationHeader.replace(environment.getProperty("authorization.token.header.prefix"), "");
		String userId = Jwts.parser().setSigningKey(environment.getProperty("token.secret")).parseClaimsJws(token)
				.getBody().getSubject();
		
		if (userId == null) {
			return null;
		}
		
		return new UsernamePasswordAuthenticationToken(userId, null, new ArrayList<>());
	}
}