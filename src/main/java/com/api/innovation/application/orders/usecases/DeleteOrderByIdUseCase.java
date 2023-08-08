package com.api.innovation.application.orders.usecases;

import org.springframework.stereotype.Component;

import com.api.innovation.application.orders.services.DeleteOrderByIdService;

@Component
public class DeleteOrderByIdUseCase {
    private final DeleteOrderByIdService deleteOrderByIdService;

	public DeleteOrderByIdUseCase(DeleteOrderByIdService deleteOrderByIdService) {
		this.deleteOrderByIdService = deleteOrderByIdService;
	}

	public void execute(Long id) {
		deleteOrderByIdService.execute(id);
	}
}
