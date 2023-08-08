package com.api.innovation.application.clients.services;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.api.innovation.application.clients.dto.requests.ClientUpdateDTO;
import com.api.innovation.infra.databases.hibernate.clients.models.Client;
import com.api.innovation.infra.databases.hibernate.clients.repositories.ClientRepository;

@Service
public class UpdateClientByIdService {
	private final ClientRepository clientRepository;
	private final GetClientByIdService getClientByIdService;

	public UpdateClientByIdService(
		ClientRepository clientRepository,
		GetClientByIdService getClientByIdService
	) {
		this.clientRepository = clientRepository;
		this.getClientByIdService = getClientByIdService;
	}

	public Client execute(Long id, ClientUpdateDTO clientUpdateDTO) {
		clientUpdateDTO.setId(id);

		com.api.innovation.domain.clients.entities.Client clientEntity = new com.api.innovation.domain.clients.entities.Client(
			clientUpdateDTO.getId(),
			clientUpdateDTO.getName(),
			clientUpdateDTO.getLastname(),
			clientUpdateDTO.getEmail(),
			clientUpdateDTO.getCpf(),
			clientUpdateDTO.getPhone(),
			clientUpdateDTO.getAddress(),
			null,
			null
		);

		Client client = getClientByIdService.execute(id);
		BeanUtils.copyProperties(clientEntity, client);

		return clientRepository.save(client);
	}
}
