package com.api.innovation.application.users.usecases;

import com.api.innovation.application.users.services.GetUserByIdService;
import com.api.innovation.infra.databases.hibernate.users.models.User;

import org.springframework.stereotype.Component;

@Component
public class GetUserByIdUseCase {
	private GetUserByIdService getUserByIdService;

	public GetUserByIdUseCase(GetUserByIdService getUserByIdService) {
		this.getUserByIdService = getUserByIdService;
	}

	public User execute(Long id) {
		return getUserByIdService.execute(id);
	}
}
