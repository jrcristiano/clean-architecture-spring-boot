package com.api.innovation.presentation.controllers.users;



import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.innovation.application.users.usecases.DeleteUserByIdUseCase;
import com.api.innovation.infra.handlers.exceptions.InternalServerErrorException;

@RestController
@RequestMapping("/api/users")
public class DeleteUserByIdController {
	private final DeleteUserByIdUseCase deleteUserByIdUseCase;

	public DeleteUserByIdController(DeleteUserByIdUseCase deleteUserByIdUseCase) {
		this.deleteUserByIdUseCase = deleteUserByIdUseCase;
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> execute(@PathVariable("id") Long id) {
		try {
			deleteUserByIdUseCase.execute(id);
			
			return ResponseEntity.noContent().build();

		} catch (Exception exception) {
            throw new InternalServerErrorException(exception.getMessage());
        }
	}
}
