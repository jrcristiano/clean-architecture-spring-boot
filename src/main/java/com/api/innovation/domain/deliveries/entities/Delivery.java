package com.api.innovation.domain.deliveries.entities;

import java.time.LocalDateTime;

import com.api.innovation.infra.databases.hibernate.orders.models.Order;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Delivery {
    private Long id;
	private String deliveryName;
	private String deliveryAddress;
	private String status;
    private Long order;
    private LocalDateTime createdAt;
	private LocalDateTime updatedAt;

	public Delivery(
		Long id,
		String status,
        Long order,
		String deliveryName,
		LocalDateTime createdAt,
		LocalDateTime updatedAt
	) {
		this.id = id;
		this.status = status;
        this.order = order;
		this.deliveryName = deliveryName;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
}