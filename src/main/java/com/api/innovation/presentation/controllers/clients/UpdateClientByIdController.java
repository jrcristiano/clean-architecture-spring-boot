package com.api.innovation.presentation.controllers.clients;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.innovation.application.clients.dto.requests.ClientRequestDTO;
import com.api.innovation.application.clients.dto.requests.ClientUpdateDTO;
import com.api.innovation.application.clients.usecases.UpdateClientByIdUseCase;
import com.api.innovation.infra.databases.hibernate.clients.models.Client;
import com.api.innovation.infra.handlers.exceptions.InternalServerErrorException;

@RestController
@RequestMapping("/api/clients")
public class UpdateClientByIdController {
	private final UpdateClientByIdUseCase updateClientByIdUseCase;

	public UpdateClientByIdController(UpdateClientByIdUseCase updateClientByIdUseCase) {
		this.updateClientByIdUseCase = updateClientByIdUseCase;
	}

	@PutMapping("/{id}")
	public ResponseEntity<ClientRequestDTO> execute(
		@PathVariable("id") Long id, @RequestBody @Valid ClientUpdateDTO clientUpdateDTO
	) {
		try {
			Client updatedClient = updateClientByIdUseCase.execute(id, clientUpdateDTO);

			return ResponseEntity.status(HttpStatus.OK).body(
				(ClientRequestDTO) new ClientUpdateDTO().convertToDTO(updatedClient)
			);
			
		} catch (Exception exception) {
            throw new InternalServerErrorException(exception.getMessage());
        }
	}
}
