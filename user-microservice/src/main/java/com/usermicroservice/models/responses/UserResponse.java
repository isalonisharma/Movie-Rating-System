package com.usermicroservice.models.responses;

import java.io.Serializable;

import com.usermicroservice.models.DTO.UserDTO;

public class UserResponse implements Serializable{

	private static final long serialVersionUID = -2990740838429789561L;
	
	private Long id;
	private String firstName;
	private String lastName;
	private String username;

	public UserResponse() {
		super();
	}
	
	public UserResponse(Long id, String firstName, String lastName, String username) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
	}

	public UserResponse(UserDTO userDTO) {
		super();
		this.id = userDTO.getId();
		this.firstName = userDTO.getFirstName();
		this.lastName = userDTO.getLastName();
		this.username = userDTO.getUsername();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "UserResponse [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", username="
				+ username + "]";
	}
}