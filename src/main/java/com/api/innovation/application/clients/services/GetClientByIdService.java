package com.api.innovation.application.clients.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.api.innovation.infra.databases.hibernate.clients.models.Client;
import com.api.innovation.infra.databases.hibernate.clients.repositories.ClientRepository;
import com.api.innovation.infra.handlers.exceptions.EntityNotFoundErrorException;

@Service
public class GetClientByIdService {
    private ClientRepository clientRepository;

	public GetClientByIdService(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}

	public Client execute(Long id) {
		Optional<Client> client = clientRepository.findById(id);
		if (!client.isPresent()) {
			throw new EntityNotFoundErrorException("Client ID " + id.toString() + " not found.");
		}

		return client.get();
	}
}
