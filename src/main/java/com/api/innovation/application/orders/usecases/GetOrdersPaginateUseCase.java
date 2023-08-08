package com.api.innovation.application.orders.usecases;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.api.innovation.application.orders.services.GetOrdersPaginateService;
import com.api.innovation.infra.databases.hibernate.orders.models.Order;

@Component
public class GetOrdersPaginateUseCase {
    private final GetOrdersPaginateService getOrdersPaginateUseCase;

    public GetOrdersPaginateUseCase(GetOrdersPaginateService getOrdersPaginateUseCase) {
		this.getOrdersPaginateUseCase = getOrdersPaginateUseCase;
	}

	public Page<Order> execute(String page, String limit, String orderBy, String sortBy) {
		return this.getOrdersPaginateUseCase.execute(page, limit, orderBy, sortBy);
	}
}
