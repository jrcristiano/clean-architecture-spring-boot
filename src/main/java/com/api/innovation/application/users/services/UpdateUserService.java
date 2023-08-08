package com.api.innovation.application.users.services;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.api.innovation.application.users.dto.requests.UserUpdateDTO;
import com.api.innovation.infra.databases.hibernate.users.models.User;
import com.api.innovation.infra.databases.hibernate.users.repositories.UserRepository;
import com.api.innovation.infra.databases.hibernate.users.utils.BcryptPassword;

@Service
public class UpdateUserService {
	private final UserRepository userRepository;
	private final GetUserByIdService getUserByIdService;

	public UpdateUserService(
		UserRepository userRepository,
		GetUserByIdService getUserByIdService
	) {
		this.userRepository = userRepository;
		this.getUserByIdService = getUserByIdService;
	}

	public User execute(Long id, UserUpdateDTO userUpdateDTO) {
		userUpdateDTO.setId(id);

		com.api.innovation.domain.users.entities.User userEntity = new com.api.innovation.domain.users.entities.User(
			userUpdateDTO.getId(),
			userUpdateDTO.getName(),
			userUpdateDTO.getLastname(),
			userUpdateDTO.getEmail(),
			BcryptPassword.encode(userUpdateDTO.getPassword()),
			null,
			userUpdateDTO.getUpdatedAt()
		);

		User user = getUserByIdService.execute(id);
		BeanUtils.copyProperties(userEntity, user);

		return userRepository.save(user);
	}
}
