package com.api.innovation.application.orders.dto.requests;

import java.time.LocalDateTime;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.api.innovation.infra.databases.hibernate.clients.models.Client;
import com.api.innovation.infra.databases.hibernate.orders.models.Order;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRequestDTO {
    protected Long id;

	@NotBlank(message = "The field productName is required")
	protected String productName;

	@NotNull(message = "The field price name is required")
	protected Double price;

	@NotNull(message = "client cannot be empty or null")
	@Min(value = 1, message = "client must be at least 1")
	protected Long client;

	protected LocalDateTime createdAt;

	protected LocalDateTime updatedAt;

	public OrderRequestDTO convertToDTO(Order order) {
		com.api.innovation.domain.orders.entities.Order orderEntity = new com.api.innovation.domain.orders.entities.Order(
			order.getId(),
			order.getProductName(),
			order.getPrice(),
			order.getClient().getId(),
			order.getCreatedAt(),
			order.getUpdatedAt()
		);

		this.setId(orderEntity.getId());
		this.setProductName(orderEntity.getProductName());
		this.setPrice(orderEntity.getPrice());
		this.setClient(orderEntity.getClient());
		this.setCreatedAt(orderEntity.getCreatedAt());
		this.setUpdatedAt(orderEntity.getUpdatedAt());

		return this;
	}
}
