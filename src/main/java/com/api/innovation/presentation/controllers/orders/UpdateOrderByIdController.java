package com.api.innovation.presentation.controllers.orders;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.innovation.application.orders.dto.requests.OrderRequestDTO;
import com.api.innovation.application.orders.dto.requests.OrderUpdateDTO;
import com.api.innovation.application.orders.usecases.UpdateOrderByIdUseCase;
import com.api.innovation.infra.databases.hibernate.orders.models.Order;
import com.api.innovation.infra.handlers.exceptions.InternalServerErrorException;

@RestController
@RequestMapping("/api/orders")
public class UpdateOrderByIdController {
    private final UpdateOrderByIdUseCase UpdateOrderByIdUseCase;

	public UpdateOrderByIdController(UpdateOrderByIdUseCase UpdateOrderByIdUseCase) {
		this.UpdateOrderByIdUseCase = UpdateOrderByIdUseCase;
	}

	@PutMapping("/{id}")
	public ResponseEntity<OrderRequestDTO> execute(
		@PathVariable("id") Long id, @RequestBody @Valid OrderUpdateDTO orderUpdateDTO
	) {
		try {
			Order updatedOrder = UpdateOrderByIdUseCase.execute(id, orderUpdateDTO);

			return ResponseEntity.status(HttpStatus.OK).body(
				(OrderRequestDTO) new OrderRequestDTO().convertToDTO(updatedOrder)
			);
			
		} catch (Exception exception) {
            throw new InternalServerErrorException(exception.getMessage());
        }
	}
}
