package com.api.innovation.application.users.usecases;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.api.innovation.application.users.services.GetUsersPaginateService;
import com.api.innovation.infra.databases.hibernate.users.models.User;

@Component()
public class GetUsersPaginateUseCase {
	private GetUsersPaginateService getUsersPaginateService;

	public GetUsersPaginateUseCase(GetUsersPaginateService getUsersPaginateService) {
		this.getUsersPaginateService = getUsersPaginateService;
	}

	public Page<User> execute(String page, String limit, String orderBy, String sortBy) {
		return this.getUsersPaginateService.execute(page, limit, orderBy, sortBy);
	}
}
