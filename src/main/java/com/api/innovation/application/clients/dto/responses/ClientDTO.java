package com.api.innovation.application.clients.dto.responses;

import java.time.LocalDateTime;

import com.api.innovation.infra.databases.hibernate.clients.models.Client;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientDTO {
	protected Long id;

	protected String name;

	protected String lastname;

	protected String cpf;

	protected String email;

	protected String phone;

	protected String address;

	protected LocalDateTime createdAt;

	protected LocalDateTime updatedAt;

	public ClientDTO() {}

	public ClientDTO convertToDTO(Client client) {
		com.api.innovation.domain.clients.entities.Client clientEntity = new com.api.innovation.domain.clients.entities.Client(
			client.getId(),
			client.getName(),
			client.getLastname(),	
			client.getEmail(),
			client.getCpf(),
			client.getPhone(),
			client.getAddress(),
			client.getCreatedAt(),
			client.getUpdatedAt()
		);

		this.setId(clientEntity.getId());
		this.setName(clientEntity.getName());
		this.setLastname(clientEntity.getLastname());
		this.setEmail(clientEntity.getEmail());
		this.setCpf(clientEntity.getCpf());
		this.setPhone(clientEntity.getPhone());
		this.setAddress(clientEntity.getAddress());
		this.setCreatedAt(clientEntity.getCreatedAt());
		this.setUpdatedAt(clientEntity.getUpdatedAt());

		return this;
	}
}
