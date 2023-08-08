package com.api.innovation.application.clients.usecases;

import org.springframework.stereotype.Component;

import com.api.innovation.application.clients.dto.requests.ClientUpdateDTO;
import com.api.innovation.application.clients.services.UpdateClientByIdService;
import com.api.innovation.infra.databases.hibernate.clients.models.Client;

@Component
public class UpdateClientByIdUseCase {

    private final UpdateClientByIdService updateClientService;

	public UpdateClientByIdUseCase(UpdateClientByIdService updateClientService) {
		this.updateClientService = updateClientService;
	}

	public Client execute(Long id, ClientUpdateDTO clientUpdateDTO) {
		return updateClientService.execute(id, clientUpdateDTO);
	}
}
