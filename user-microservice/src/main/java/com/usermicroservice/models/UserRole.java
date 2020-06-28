package com.usermicroservice.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_role")
public class UserRole implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user", nullable = false)
	private User user;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "role", nullable = false)
	private Role role;

	public UserRole() {
	}

	public UserRole(long id, User user, Role role) {
		super();
		this.id = id;
		this.user = user;
		this.role = role;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "UserRole [id=" + id + ", user=" + user + ", role=" + role + "]";
	}
}
