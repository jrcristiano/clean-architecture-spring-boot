package com.api.innovation.application.users.usecases;

import com.api.innovation.application.users.services.DeleteUserByIdService;

import org.springframework.stereotype.Component;

@Component
public class DeleteUserByIdUseCase {
	private final DeleteUserByIdService deleteUserByIdService;

	public DeleteUserByIdUseCase(DeleteUserByIdService deleteUserByIdService) {
		this.deleteUserByIdService = deleteUserByIdService;
	}

	public void execute(Long id) {
		deleteUserByIdService.execute(id);
	}
}
