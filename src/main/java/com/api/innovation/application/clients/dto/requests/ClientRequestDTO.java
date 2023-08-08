package com.api.innovation.application.clients.dto.requests;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.api.innovation.infra.databases.hibernate.clients.models.Client;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public abstract class ClientRequestDTO {
	protected Long id;

	@NotBlank(message = "The field name is required")
	@Size(min = 3, max = 32, message = "The field name must have between 3 and 32 characters")
	protected String name;

	@NotBlank(message = "The field lastname is required")
	@Size(min = 3, max = 128, message = "The field lastname is required")
	protected String lastname;

	@NotBlank(message = "The field email is required")
	@Email(message = "The field email must be a valid e-mail address")
	protected String email;

	@NotBlank(message = "The field cpf is required")
	protected String cpf;

	@NotBlank(message = "The field phone is required")
	@Size(min = 8, message = "The field name must have min 8 characteres")
	protected String phone;

	@NotBlank(message = "The field address is required")
	@Size(min = 3, message = "The field address must have min 3 characteres")
	protected String address;

	protected LocalDateTime createdAt;

	protected LocalDateTime updatedAt;

	public ClientRequestDTO convertToDTO(Client client) {
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
