package com.api.innovation.application.orders.services;

import org.springframework.stereotype.Service;

import com.api.innovation.application.clients.usecases.GetClientByIdUseCase;
import com.api.innovation.application.orders.usecases.GetOrderByIdUseCase;
import com.api.innovation.infra.databases.hibernate.orders.models.Order;
import com.api.innovation.infra.databases.hibernate.orders.repositories.OrderRepository;

@Service
public class DeleteOrderByIdService {
    private final OrderRepository orderRepository;
	private final GetOrderByIdUseCase getOrderByIdUseCase;
	private final GetClientByIdUseCase getClientByIdUseCase;

	public DeleteOrderByIdService(
		OrderRepository orderRepository,
		GetOrderByIdUseCase getOrderByIdUseCase,
		GetClientByIdUseCase getClientByIdUseCase
	) {
		this.orderRepository = orderRepository;
		this.getOrderByIdUseCase = getOrderByIdUseCase;
		this.getClientByIdUseCase = getClientByIdUseCase;
	}

	public void execute(Long id) {
		Order order = getOrderByIdUseCase.execute(id);

		getClientByIdUseCase.execute(order.getClient().getId());
		
		orderRepository.deleteById(id);
	}
}
