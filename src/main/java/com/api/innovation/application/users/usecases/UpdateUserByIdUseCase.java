package com.api.innovation.application.users.usecases;



import org.springframework.stereotype.Component;

import com.api.innovation.application.users.dto.requests.UserUpdateDTO;
import com.api.innovation.application.users.services.UpdateUserService;
import com.api.innovation.infra.databases.hibernate.users.models.User;

@Component
public class UpdateUserByIdUseCase {
	private final UpdateUserService updateUserService;

	public UpdateUserByIdUseCase(UpdateUserService updateUserService) {
		this.updateUserService = updateUserService;
	}

	public User execute(Long id, UserUpdateDTO userUpdateDTO) {
		return updateUserService.execute(id, userUpdateDTO);
	}
}
