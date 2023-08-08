package com.api.innovation.application.users.dto.requests;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.api.innovation.infra.databases.hibernate.users.models.User;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public abstract class UserRequestDTO {
	protected Long id;

	@NotBlank(message = "The field name is required")
	@Size(min = 3, max = 32, message = "The field name must have between 3 and 32 characters")
	protected String name;

	@NotBlank(message = "The field lastname is required")
	@Size(min = 3, max = 128, message = "The field lastname is required")
	protected String lastname;

	@NotBlank(message = "The field email is required")
	@Email(message = "The field email must be a valid e-mail address")
	@Size(max = 255, message = "The field email is required")
	protected String email;

	@NotBlank(message = "The field password is required")
	@Size(min = 8, max = 255, message = "The field password must have between 8 and 255 characters")
	protected String password;

	protected LocalDateTime createdAt;

	protected LocalDateTime updatedAt;

	public UserRequestDTO convertToDTO(User user) {
		com.api.innovation.domain.users.entities.User userEntity = new com.api.innovation.domain.users.entities.User(
			user.getId(),
			user.getName(),
			user.getLastname(),
			user.getEmail(),
			user.getPassword(),
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
