package com.usermicroservice.models.requests;

import java.io.Serializable;

public class AuthenticationRequest implements Serializable {

	private static final long serialVersionUID = -2478596945690148272L;
	
	private String username;
	private String password;

	// need default constructor for JSON Parsing
	public AuthenticationRequest() {
		super();
	}

	public AuthenticationRequest(String username, String password) {
		super();
		this.setUsername(username);
		this.setPassword(password);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "AuthenticationRequest [username=" + username + ", password=" + password + "]";
	}
}