package com.api.innovation.application.orders.usecases;

import org.springframework.stereotype.Component;

import com.api.innovation.application.orders.dto.requests.OrderCreateDTO;
import com.api.innovation.application.orders.services.CreateOrderService;
import com.api.innovation.infra.databases.hibernate.orders.models.Order;

@Component
public class CreateOrderUseCase {
    private final CreateOrderService createOrderService ;

	public CreateOrderUseCase(CreateOrderService createOrderService) {
		this.createOrderService = createOrderService;
	}

	public Order execute(OrderCreateDTO orderCreateDTO) {
		return createOrderService.execute(orderCreateDTO);
	}
}
