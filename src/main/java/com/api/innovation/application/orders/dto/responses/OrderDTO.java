package com.api.innovation.application.orders.dto.responses;

import java.time.LocalDateTime;

import com.api.innovation.infra.databases.hibernate.clients.models.Client;
import com.api.innovation.infra.databases.hibernate.orders.models.Order;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDTO {
    protected Long id;

	protected String productName;

	protected Double price;

	protected LocalDateTime createdAt;

	protected LocalDateTime updatedAt;

	public OrderDTO() {}

	public OrderDTO convertToDTO(Order order) {
		com.api.innovation.domain.orders.entities.Order orderEntity = new com.api.innovation.domain.orders.entities.Order(
			order.getId(),
			order.getProductName(),
			order.getPrice(),
			order.getClient().getId(),
			order.getCreatedAt(),
			order.getUpdatedAt()
		);
	
		Client client = new Client();
		client.setId(order.getClient().getId());
		client.setName(order.getClient().getName());
		client.setLastname(order.getClient().getLastname());
		client.setCpf(order.getClient().getCpf());
		client.setEmail(order.getClient().getEmail());
		client.setPhone(order.getClient().getPhone());
		client.setAddress(order.getClient().getAddress());
		client.setCreatedAt(order.getClient().getCreatedAt());
		client.setUpdatedAt(order.getClient().getUpdatedAt());

		this.setId(orderEntity.getId());
		this.setProductName(orderEntity.getProductName());
		this.setPrice(orderEntity.getPrice());
		this.setCreatedAt(orderEntity.getCreatedAt());
		this.setUpdatedAt(orderEntity.getUpdatedAt());

		return this;
	}
}
