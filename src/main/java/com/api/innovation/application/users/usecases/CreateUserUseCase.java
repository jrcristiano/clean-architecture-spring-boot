package com.api.innovation.application.users.usecases;

import com.api.innovation.application.users.services.CreateUserService;
import com.api.innovation.infra.databases.hibernate.users.models.User;
import com.api.innovation.application.users.dto.requests.UserCreateDTO;

import org.springframework.stereotype.Component;

@Component
public class CreateUserUseCase {
	private final CreateUserService createUserService;

	public CreateUserUseCase(CreateUserService createUserService) {
		this.createUserService = createUserService;
	}

	public User execute(UserCreateDTO userCreateDTO) {
		return createUserService.execute(userCreateDTO);
	}
}
