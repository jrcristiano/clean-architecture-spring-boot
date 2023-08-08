package com.api.innovation.domain.clients.entities;

import java.time.LocalDateTime;

public class Client {
    private Long id;
	private String name;
	private String lastname;
	private String email;
    private String cpf;
    private String phone;
    private String address;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;

    public Client(
		Long id,
		String name,
		String lastname,
		String email,
        String cpf,
        String phone,
        String address,
		LocalDateTime createdAt,
		LocalDateTime updatedAt
	) {
		this.id = id;
		this.name = name;
		this.lastname = lastname;
		this.email = email;
        this.cpf = cpf;
        this.phone = phone;
        this.address = address;
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

	public String getCpf() {
		return cpf;
	}

    public String getPhone() {
		return phone;
	}

    public String getAddress() {
		return address;
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
