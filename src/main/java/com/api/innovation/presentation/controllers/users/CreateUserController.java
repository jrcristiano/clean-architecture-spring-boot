package com.api.innovation.presentation.controllers.users;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.innovation.application.users.dto.requests.UserCreateDTO;
import com.api.innovation.application.users.dto.responses.UserDTO;
import com.api.innovation.application.users.usecases.CreateUserUseCase;
import com.api.innovation.infra.databases.hibernate.users.models.User;
import com.api.innovation.infra.handlers.exceptions.InternalServerErrorException;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class CreateUserController {
	private final CreateUserUseCase createUserUseCase;

	public CreateUserController(CreateUserUseCase createUserUseCase) {
		this.createUserUseCase = createUserUseCase;
	}

	@ApiResponses(value = {
        @ApiResponse(code = 201, message = "Recurso criado com sucesso"),
        @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
	@PostMapping
	public ResponseEntity<UserDTO> execute(@RequestBody @Valid UserCreateDTO userCreateDTO) {
		try {
			User createdUser = createUserUseCase.execute(userCreateDTO);

			return ResponseEntity.status(HttpStatus.CREATED).body(
				(UserDTO) new UserDTO().convertToDTO(createdUser)
			);
			
		} catch (Exception exception) {
            throw new InternalServerErrorException(exception.getMessage());
        }
	}
}
