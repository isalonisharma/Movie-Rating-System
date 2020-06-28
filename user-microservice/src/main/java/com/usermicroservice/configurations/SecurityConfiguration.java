package com.usermicroservice.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.usermicroservice.filters.AuthenticationFilter;
import com.usermicroservice.services.AuthenticationUserService;
import com.usermicroservice.services.UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	@Autowired
	private AuthenticationUserService authenticationUserService;

	@Autowired
	private UserService userService;

	private Environment environment;

	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	public SecurityConfiguration(Environment environment, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.environment = environment;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		String gatewayIp = environment.getProperty("gateway.ip");
		httpSecurity.csrf().disable();
		httpSecurity.authorizeRequests().antMatchers("/**").hasIpAddress(gatewayIp).and()
				.addFilter(getAuthenticationFilter());
	}

	private AuthenticationFilter getAuthenticationFilter() throws Exception {
		String authenticationURLPath = environment.getProperty("authentication.url.path");
		AuthenticationFilter authenticationFilter = new AuthenticationFilter(authenticationManager(), environment,
				userService);
		authenticationFilter.setFilterProcessesUrl(authenticationURLPath);
		return authenticationFilter;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(authenticationUserService).passwordEncoder(bCryptPasswordEncoder);
	}
}