package com.api.innovation.application.users.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.api.innovation.infra.databases.hibernate.users.models.User;
import com.api.innovation.infra.databases.hibernate.users.repositories.UserRepository;
import com.api.innovation.infra.handlers.exceptions.EntityNotFoundErrorException;

@Service
public class GetUserByIdService {
	private UserRepository userRepository;

	public GetUserByIdService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public User execute(Long id) {
		Optional<User> user = userRepository.findById(id);
		if (!user.isPresent()) {
			throw new EntityNotFoundErrorException("User ID " + id.toString() + " not found.");
		}

		return user.get();
	}
}
