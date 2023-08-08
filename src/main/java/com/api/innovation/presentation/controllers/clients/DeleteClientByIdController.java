package com.api.innovation.presentation.controllers.clients;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.innovation.application.clients.usecases.DeleteClientByIdUseCase;

@RestController
@RequestMapping("/api/clients")
public class DeleteClientByIdController {
    private final DeleteClientByIdUseCase deleteClientByIdUseCase;

	public DeleteClientByIdController(DeleteClientByIdUseCase deleteClientByIdUseCase) {
		this.deleteClientByIdUseCase = deleteClientByIdUseCase;
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> execute(@PathVariable("id") Long id) {
		deleteClientByIdUseCase.execute(id);
			
		return ResponseEntity.noContent().build();
	}
}
