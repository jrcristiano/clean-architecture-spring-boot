package com.api.innovation.presentation.controllers.clients;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.innovation.application.clients.dto.requests.ClientCreateDTO;
import com.api.innovation.application.clients.dto.responses.ClientDTO;
import com.api.innovation.application.clients.usecases.CreateClientUseCase;
import com.api.innovation.infra.databases.hibernate.clients.models.Client;
import com.api.innovation.infra.handlers.exceptions.InternalServerErrorException;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/clients")
public class CreateClientController {
    private final CreateClientUseCase createClientUseCase;

	public CreateClientController(CreateClientUseCase createClientUseCase) {
		this.createClientUseCase = createClientUseCase;
	}

	@ApiResponses(value = {
        @ApiResponse(code = 201, message = "Recurso criado com sucesso"),
        @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
	@PostMapping
	public ResponseEntity<ClientDTO> execute(@RequestBody @Valid ClientCreateDTO clientCreateDTO) {
		try {
			Client createdClient = createClientUseCase.execute(clientCreateDTO);

			return ResponseEntity.status(HttpStatus.CREATED).body(
				(ClientDTO) new ClientDTO().convertToDTO(createdClient)
			);
			
		} catch (Exception exception) {
            throw new InternalServerErrorException(exception.getMessage());
        }
	}
}
