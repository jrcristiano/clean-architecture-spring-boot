package com.api.innovation.application.clients.usecases;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.api.innovation.infra.databases.hibernate.clients.models.Client;
import com.api.innovation.infra.databases.hibernate.clients.repositories.ClientRepository;
import com.api.innovation.infra.handlers.exceptions.EntityNotFoundErrorException;

@Component
public class GetClientByEmailUseCase {
    private final ClientRepository clientRepository;

	public GetClientByEmailUseCase(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}

    public Optional<Client> execute(String email) {
		Optional<Client> client = clientRepository.findClientByEmail(email);

		if (!client.isPresent()) {
			throw new EntityNotFoundErrorException("User email " + email + " not found.");
		}

		return client;
	}
}
