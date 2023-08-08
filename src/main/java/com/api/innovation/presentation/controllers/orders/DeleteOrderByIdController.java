package com.api.innovation.presentation.controllers.orders;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.innovation.application.orders.usecases.DeleteOrderByIdUseCase;

@RestController
@RequestMapping("/api/orders")
public class DeleteOrderByIdController {
    private final DeleteOrderByIdUseCase deleteOrderByIdUseCase;

	public DeleteOrderByIdController(DeleteOrderByIdUseCase deleteOrderByIdUseCase) {
		this.deleteOrderByIdUseCase = deleteOrderByIdUseCase;
	}

    @DeleteMapping("/{id}")
	public ResponseEntity<?> execute(@PathVariable("id") Long id) {
		deleteOrderByIdUseCase.execute(id);
			
		return ResponseEntity.noContent().build();
	}
}
