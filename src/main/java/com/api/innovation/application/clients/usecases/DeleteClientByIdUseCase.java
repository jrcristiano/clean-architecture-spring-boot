package com.api.innovation.application.clients.usecases;

import org.springframework.stereotype.Component;

import com.api.innovation.application.clients.services.GetClientByIdService;
import com.api.innovation.infra.databases.hibernate.clients.repositories.ClientRepository;

@Component
public class DeleteClientByIdUseCase {
    private ClientRepository clientRepository;
	private GetClientByIdService getClientByIdService;

	public DeleteClientByIdUseCase(
		ClientRepository clientRepository,
		GetClientByIdService getClientByIdService
	) {
		this.clientRepository = clientRepository;
		this.getClientByIdService = getClientByIdService;
	}

	public void execute(Long id) {
		getClientByIdService.execute(id);
		clientRepository.deleteById(id);
	}
}
