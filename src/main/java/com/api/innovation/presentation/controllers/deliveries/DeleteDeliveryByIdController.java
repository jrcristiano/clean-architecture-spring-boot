package com.api.innovation.presentation.controllers.deliveries;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.innovation.application.deliveries.usecases.DeleteDeliveryByIdUseCase;

@RestController
@RequestMapping("/api/deliveries")
public class DeleteDeliveryByIdController {
    private final DeleteDeliveryByIdUseCase deleteDeliveryByIdUseCase;

	public DeleteDeliveryByIdController(DeleteDeliveryByIdUseCase deleteDeliveryByIdUseCase) {
		this.deleteDeliveryByIdUseCase = deleteDeliveryByIdUseCase;
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> execute(@PathVariable("id") Long id) {
		deleteDeliveryByIdUseCase.execute(id);
			
		return ResponseEntity.noContent().build();
	}
}
