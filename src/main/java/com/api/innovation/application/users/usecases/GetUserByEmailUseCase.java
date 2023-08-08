package com.api.innovation.application.users.usecases;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.api.innovation.application.users.services.GetUserByEmailService;
import com.api.innovation.infra.databases.hibernate.users.models.User;

@Component
public class GetUserByEmailUseCase {
    private GetUserByEmailService getUserByEmailService;

	public GetUserByEmailUseCase(GetUserByEmailService getUserByEmailService) {
		this.getUserByEmailService = getUserByEmailService;
	}

	public Optional<User> execute(String email) {
		return getUserByEmailService.execute(email);
	}
}
