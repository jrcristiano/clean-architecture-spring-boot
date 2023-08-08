package com.api.innovation.application.deliveries.dto.requests;

import java.time.LocalDateTime;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.api.innovation.infra.databases.hibernate.deliveries.models.Delivery;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeliveryRequestDTO {
    protected Long id;

	@NotBlank(message = "The field deliveryName is required")
	protected String deliveryName;

	@NotBlank(message = "The field status is required")
	protected String status;


	@NotNull(message = "order cannot be empty or null")
	@Min(value = 1, message = "Order must be at least 1")
	protected Long order;

	protected LocalDateTime createdAt;

	protected LocalDateTime updatedAt;

	public DeliveryRequestDTO convertToDTO(Delivery delivery) {
		com.api.innovation.domain.deliveries.entities.Delivery deliveryEntity = new com.api.innovation.domain.deliveries.entities.Delivery(
			delivery.getId(),
			delivery.getStatus(),
			delivery.getOrder().getId(),
			delivery.getDeliveryName(),
			delivery.getCreatedAt(),
			delivery.getUpdatedAt()
		);

		this.setId(deliveryEntity.getId());
		this.setStatus(deliveryEntity.getStatus());
		this.setOrder(deliveryEntity.getOrder());
		this.setDeliveryName(deliveryEntity.getDeliveryName());
		this.setCreatedAt(deliveryEntity.getCreatedAt());
		this.setUpdatedAt(deliveryEntity.getUpdatedAt());

		return this;
	}
}