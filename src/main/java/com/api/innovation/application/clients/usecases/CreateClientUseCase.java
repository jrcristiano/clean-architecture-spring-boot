package com.api.innovation.application.clients.usecases;

import org.springframework.stereotype.Component;

import com.api.innovation.application.clients.dto.requests.ClientCreateDTO;
import com.api.innovation.application.clients.services.CreateClientService;
import com.api.innovation.infra.databases.hibernate.clients.models.Client;

@Component
public class CreateClientUseCase {
    private final CreateClientService createClientService;

	public CreateClientUseCase(CreateClientService createClientService) {
		this.createClientService = createClientService;
	}

	public Client execute(ClientCreateDTO userCreateDTO) {
		return createClientService.execute(userCreateDTO);
	}
}
