package com.api.innovation.application.orders.services;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.api.innovation.application.clients.services.GetClientByIdService;
import com.api.innovation.application.orders.dto.requests.OrderCreateDTO;
import com.api.innovation.infra.databases.hibernate.clients.models.Client;
import com.api.innovation.infra.databases.hibernate.orders.models.Order;
import com.api.innovation.infra.databases.hibernate.orders.repositories.OrderRepository;

@Service
public class CreateOrderService {
    private final OrderRepository orderRepository;
	private final GetClientByIdService getClientByIdService;

	public CreateOrderService(OrderRepository orderRepository, GetClientByIdService getClientByIdService) {
		this.orderRepository = orderRepository;
		this.getClientByIdService = getClientByIdService;
	}

    public Order execute(OrderCreateDTO orderCreateDTO) {
		Client client = this.getClientByIdService.execute(
			orderCreateDTO.getClient()
		);

		com.api.innovation.domain.orders.entities.Order orderEntity = new com.api.innovation.domain.orders.entities.Order(
			orderCreateDTO.getId(),
			orderCreateDTO.getProductName(),
			orderCreateDTO.getPrice(),
			orderCreateDTO.getClient(),
			orderCreateDTO.getCreatedAt(),
			orderCreateDTO.getUpdatedAt()
		);

		Order order = new Order();
		order.setClient(client);
		
		BeanUtils.copyProperties(orderEntity, order);

		return orderRepository.save(order);
	}
}
