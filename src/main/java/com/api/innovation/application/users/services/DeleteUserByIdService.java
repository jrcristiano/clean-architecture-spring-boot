package com.api.innovation.application.users.services;

import org.springframework.stereotype.Service;

import com.api.innovation.infra.databases.hibernate.users.repositories.UserRepository;

@Service
public class DeleteUserByIdService {
	private UserRepository userRepository;
	private GetUserByIdService getUserByIdService;

	public DeleteUserByIdService(
		UserRepository userRepository,
		GetUserByIdService getUserByIdService
	) {
		this.userRepository = userRepository;
		this.getUserByIdService = getUserByIdService;
	}

	public void execute(Long id) {
		getUserByIdService.execute(id);
		userRepository.deleteById(id);
	}
}
