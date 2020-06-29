package com.zuulapigateway.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

import com.zuulapigateway.filters.AuthorizationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	private final Environment environment;

    @Autowired
    public SecurityConfiguration(Environment environment) {
        this.environment = environment;
    }
    
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
    	httpSecurity.csrf().disable(); 
   
    	httpSecurity.authorizeRequests()
    	.antMatchers(HttpMethod.POST, environment.getProperty("api.registration.url.path")).permitAll()
    	.antMatchers(HttpMethod.POST, environment.getProperty("api.authentication.url.path")).permitAll()
    	.anyRequest().authenticated()
    	.and()
    	.addFilter(new AuthorizationFilter(authenticationManager(), environment));
    	
    	httpSecurity.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }
}