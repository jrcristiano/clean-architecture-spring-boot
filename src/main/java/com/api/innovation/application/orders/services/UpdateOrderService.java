package com.api.innovation.application.orders.services;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.api.innovation.application.clients.services.GetClientByIdService;
import com.api.innovation.application.orders.dto.requests.OrderUpdateDTO;
import com.api.innovation.infra.databases.hibernate.clients.models.Client;
import com.api.innovation.infra.databases.hibernate.orders.models.Order;
import com.api.innovation.infra.databases.hibernate.orders.repositories.OrderRepository;
import com.api.innovation.infra.handlers.exceptions.EntityNotFoundErrorException;

@Service
public class UpdateOrderService {
    private final OrderRepository orderRepository;
	private final GetClientByIdService getClientByIdService;

	public UpdateOrderService(OrderRepository orderRepository, GetClientByIdService getClientByIdService) {
		this.orderRepository = orderRepository;
		this.getClientByIdService = getClientByIdService;
	}

	public Order execute(Long id, OrderUpdateDTO orderUpdateDTO) {
		Client client = this.getClientByIdService.execute(
			orderUpdateDTO.getClient()
		);

		if (client == null) {
			throw new EntityNotFoundErrorException("Order ID" + orderUpdateDTO.getClient() + " not found.");
		}

		orderUpdateDTO.setId(id);

		com.api.innovation.domain.orders.entities.Order orderEntity = new com.api.innovation.domain.orders.entities.Order(
			orderUpdateDTO.getId(),
			orderUpdateDTO.getProductName(),
			orderUpdateDTO.getPrice(),
			orderUpdateDTO.getClient(),
			orderUpdateDTO.getCreatedAt(),
			orderUpdateDTO.getUpdatedAt()
		);

		Order order = new Order();
		order.setClient(client);
		
		BeanUtils.copyProperties(orderEntity, order);

		return orderRepository.save(order);
	}
}
