package com.api.innovation.application.orders.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.api.innovation.infra.databases.hibernate.orders.models.Order;
import com.api.innovation.infra.databases.hibernate.orders.repositories.OrderRepository;
import com.api.innovation.infra.handlers.exceptions.EntityNotFoundErrorException;

@Service
public class GetOrderByIdService {
    private final OrderRepository orderRepository;

	public GetOrderByIdService(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}

	public Order execute(Long id) {
		Optional<Order> order = orderRepository.findById(id);
		if (!order.isPresent()) {
			throw new EntityNotFoundErrorException("Order ID " + id.toString() + " not found.");
		}

		return order.get();
	}
}
