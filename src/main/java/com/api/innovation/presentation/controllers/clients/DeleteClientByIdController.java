package com.api.innovation.presentation.controllers.clients;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.innovation.application.clients.usecases.DeleteClientByIdUseCase;
import com.api.innovation.infra.handlers.exceptions.InternalServerErrorException;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/clients")
public class DeleteClientByIdController {
    private final DeleteClientByIdUseCase deleteClientByIdUseCase;

	public DeleteClientByIdController(DeleteClientByIdUseCase deleteClientByIdUseCase) {
		this.deleteClientByIdUseCase = deleteClientByIdUseCase;
	}

	@ApiResponses(value = {
        @ApiResponse(code = 204, message = "Sem conteúdo"),
        @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
	@DeleteMapping("/{id}")
	public ResponseEntity<?> execute(@PathVariable("id") Long id) {
		try {
			deleteClientByIdUseCase.execute(id);
			
			return ResponseEntity.noContent().build();
		} catch (Exception exception) {
			throw new InternalServerErrorException(exception.getMessage());
		}
	}
}
