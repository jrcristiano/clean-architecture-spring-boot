package com.api.innovation.application.orders.usecases;

import org.springframework.stereotype.Component;

import com.api.innovation.application.orders.dto.requests.OrderUpdateDTO;
import com.api.innovation.application.orders.services.UpdateOrderService;
import com.api.innovation.infra.databases.hibernate.orders.models.Order;

@Component
public class UpdateOrderByIdUseCase {
    private final UpdateOrderService updateOrderService;

	public UpdateOrderByIdUseCase(UpdateOrderService updateOrderService) {
		this.updateOrderService = updateOrderService;
	}

	public Order execute(Long id, OrderUpdateDTO orderUpdateDTO) {
		return updateOrderService.execute(id, orderUpdateDTO);
	}
}
