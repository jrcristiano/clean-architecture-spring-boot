package com.api.innovation.application.clients.services;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.api.innovation.application.clients.dto.requests.ClientCreateDTO;
import com.api.innovation.infra.databases.hibernate.clients.models.Client;
import com.api.innovation.infra.databases.hibernate.clients.repositories.ClientRepository;
import com.api.innovation.infra.handlers.exceptions.ConflictErrorException;

@Component
public class CreateClientService {
    private final ClientRepository clientRepository;

	public CreateClientService(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}

	public Client execute(ClientCreateDTO clientCreateDTO) {
		Optional<Client> registeredClient = clientRepository.findClientByEmail(clientCreateDTO.getEmail());

		if (registeredClient.isPresent()) {
			throw new ConflictErrorException("E-mail address already exists.");
		}

		com.api.innovation.domain.clients.entities.Client clientEntity = new com.api.innovation.domain.clients.entities.Client(
			clientCreateDTO.getId(),
			clientCreateDTO.getName(),
			clientCreateDTO.getLastname(),
			clientCreateDTO.getEmail(),
			clientCreateDTO.getCpf(),
			clientCreateDTO.getPhone(),
			clientCreateDTO.getAddress(),
			null,
			null
		);

		Client client = new Client();
		
		BeanUtils.copyProperties(clientEntity, client);

		return clientRepository.save(client);
	}
}
