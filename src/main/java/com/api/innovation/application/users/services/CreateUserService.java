package com.api.innovation.application.users.services;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.api.innovation.application.users.dto.requests.UserCreateDTO;
import com.api.innovation.infra.databases.hibernate.users.models.User;
import com.api.innovation.infra.databases.hibernate.users.repositories.UserRepository;
import com.api.innovation.infra.databases.hibernate.users.utils.BcryptPassword;
import com.api.innovation.infra.handlers.exceptions.ConflictErrorException;

@Service
public class CreateUserService {
	private UserRepository userRepository;

	public CreateUserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public User execute(UserCreateDTO userCreateDTO) {
		Optional<User> registeredUser = userRepository.findUserByEmail(userCreateDTO.getEmail());

		if (registeredUser.isPresent()) {
			throw new ConflictErrorException("E-mail address already exists.");
		}

		com.api.innovation.domain.users.entities.User userEntity = new com.api.innovation.domain.users.entities.User(
			userCreateDTO.getId(),
			userCreateDTO.getName(),
			userCreateDTO.getLastname(),
			userCreateDTO.getEmail(),
			BcryptPassword.encode(userCreateDTO.getPassword()),
			null,
			null
		);

		User user = new User();
		
		BeanUtils.copyProperties(userEntity, user);

		return userRepository.save(user);
	}
}
