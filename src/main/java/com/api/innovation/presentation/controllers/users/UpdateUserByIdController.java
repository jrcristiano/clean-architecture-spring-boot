package com.api.innovation.presentation.controllers.users;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.innovation.application.users.dto.requests.UserRequestDTO;
import com.api.innovation.application.users.dto.requests.UserUpdateDTO;
import com.api.innovation.application.users.usecases.UpdateUserByIdUseCase;
import com.api.innovation.infra.databases.hibernate.users.models.User;
import com.api.innovation.infra.handlers.exceptions.InternalServerErrorException;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UpdateUserByIdController {
	private final UpdateUserByIdUseCase updateUserByIdUseCase;

	public UpdateUserByIdController(UpdateUserByIdUseCase updateUserByIdUseCase) {
		this.updateUserByIdUseCase = updateUserByIdUseCase;
	}

	@PutMapping("/{id}")
	public ResponseEntity<UserRequestDTO> execute(
		@PathVariable("id") Long id, @RequestBody @Valid UserUpdateDTO userUpdateDTO
	) {
		try {
			User updatedUser = updateUserByIdUseCase.execute(id, userUpdateDTO);

			return ResponseEntity.status(HttpStatus.OK).body(
				(UserRequestDTO) new UserUpdateDTO().convertToDTO(updatedUser)
			);
			
		} catch (Exception exception) {
            throw new InternalServerErrorException(exception.getMessage());
        }
	}
}
