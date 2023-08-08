package com.api.innovation.application.users.dto.responses;

import java.time.LocalDateTime;

import com.api.innovation.infra.databases.hibernate.users.models.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
	protected Long id;

	protected String name;

	protected String lastname;

	protected String email;

	protected LocalDateTime createdAt;

	protected LocalDateTime updatedAt;

	public UserDTO convertToDTO(User user) {
		com.api.innovation.domain.users.entities.User userEntity = new com.api.innovation.domain.users.entities.User(
			user.getId(),
			user.getName(),
			user.getLastname(),
			user.getEmail(),
			user.getCreatedAt(),
			user.getUpdatedAt()
		);

		this.setId(userEntity.getId());
		this.setName(userEntity.getName());
		this.setLastname(userEntity.getLastname());
		this.setEmail(userEntity.getEmail());
		this.setCreatedAt(userEntity.getCreatedAt());
		this.setUpdatedAt(userEntity.getUpdatedAt());

		return this;
	}
}
