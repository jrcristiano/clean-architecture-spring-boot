package com.api.innovation.domain.orders.entities;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Order {
    private Long id;
	private String productName;
	private Double price;
	private Long client;
    private LocalDateTime createdAt;
	private LocalDateTime updatedAt;

	public Order(
		Long id,
		String productName,
		Double price,
		Long client,
		LocalDateTime createdAt,
		LocalDateTime updatedAt
	) {
		this.id = id;
		this.productName = productName;
		this.price = price;
		this.client = client;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
}
