package com.api.innovation.application.users.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.api.innovation.infra.databases.hibernate.users.models.User;
import com.api.innovation.infra.databases.hibernate.users.repositories.UserRepository;
import com.api.innovation.infra.handlers.exceptions.EntityNotFoundErrorException;

@Service
public class GetUserByEmailService {

    private UserRepository userRepository;

    public GetUserByEmailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> execute(String email) {
		Optional<User> user = userRepository.findUserByEmail(email);

		if (!user.isPresent()) {
			throw new EntityNotFoundErrorException("User email " + email + " not found.");
		}

		return user;
	}
}
