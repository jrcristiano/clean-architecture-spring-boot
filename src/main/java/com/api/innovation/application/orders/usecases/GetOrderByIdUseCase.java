package com.api.innovation.application.orders.usecases;

import org.springframework.stereotype.Component;

import com.api.innovation.application.orders.services.GetOrderByIdService;
import com.api.innovation.infra.databases.hibernate.orders.models.Order;

@Component
public class GetOrderByIdUseCase {
    private final GetOrderByIdService getOrderByIdService;

	public GetOrderByIdUseCase(GetOrderByIdService getOrderByIdService) {
		this.getOrderByIdService = getOrderByIdService;
	}
    
    public Order execute(Long id) {
		return getOrderByIdService.execute(id);
	}
}
