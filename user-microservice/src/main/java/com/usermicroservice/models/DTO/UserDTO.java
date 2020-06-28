package com.usermicroservice.models.DTO;

import java.io.Serializable;

import com.usermicroservice.models.User;

public class UserDTO implements Serializable {

	private static final long serialVersionUID = -953297098295050686L;

	private Long id;
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private boolean active;

	public UserDTO() {
		super();
	}

	public UserDTO(Long id, String firstName, String lastName, String username, String password, boolean active) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.active = active;
	}

	public UserDTO(User user) {
		super();
		this.id = user.getId();
		this.firstName = user.getFirstName();
		this.lastName = user.getLastName();
		this.username = user.getUsername();
		this.password = user.getPassword();
		this.active = user.isActive();
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", username=" + username
				+ ", password=" + password + ", active=" + active + "]";
	}
}