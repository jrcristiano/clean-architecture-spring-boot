package com.api.innovation.domain.users.entities;

import java.time.LocalDateTime;

public class User {
	private Long id;
	private String name;
	private String lastname;
	private String email;
	private String password;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;

	public User(
		Long id,
		String name,
		String lastname,
		String email,
		LocalDateTime createdAt,
		LocalDateTime updatedAt
	) {
		this.id = id;
		this.name = name;
		this.lastname = lastname;
		this.email = email;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public User(
		Long id,
		String name,
		String lastname,
		String email,
		String password,
		LocalDateTime createdAt,
		LocalDateTime updatedAt
	) {
		this.id = id;
		this.name = name;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public Long getId() {
		return this.id;
	}

	public String getName() {
		return name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
	}

	public String getLastname() {
		return lastname.substring(0, 1).toUpperCase() + lastname.substring(1).toLowerCase();
	}

	public String getEmail() {
		return email.toLowerCase();
	}

	public String getPassword() {
		return password;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt != null ? createdAt : LocalDateTime.now();
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt != null ? updatedAt : LocalDateTime.now();
	}
}
