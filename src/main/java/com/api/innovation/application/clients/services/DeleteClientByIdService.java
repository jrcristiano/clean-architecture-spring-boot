package com.api.innovation.application.clients.services;

import org.springframework.stereotype.Component;

import com.api.innovation.infra.databases.hibernate.clients.repositories.ClientRepository;

@Component
public class DeleteClientByIdService {
    private ClientRepository clientRepository;
	private GetClientByIdService getClientByIdService;

	public DeleteClientByIdService(
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
