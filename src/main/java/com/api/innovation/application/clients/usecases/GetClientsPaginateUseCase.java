package com.api.innovation.application.clients.usecases;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.api.innovation.application.clients.services.GetClientsPaginateService;
import com.api.innovation.infra.databases.hibernate.clients.models.Client;

@Component
public class GetClientsPaginateUseCase {
    private GetClientsPaginateService getClientsPaginateService;

	public GetClientsPaginateUseCase(GetClientsPaginateService getClientsPaginateService) {
		this.getClientsPaginateService = getClientsPaginateService;
	}

	public Page<Client> execute(String page, String limit, String orderBy, String sortBy) {
		return this.getClientsPaginateService.execute(page, limit, orderBy, sortBy);
	}
}
