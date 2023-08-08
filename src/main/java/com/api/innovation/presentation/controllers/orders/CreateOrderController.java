package com.api.innovation.presentation.controllers.orders;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.innovation.application.orders.dto.requests.OrderCreateDTO;
import com.api.innovation.application.orders.dto.responses.OrderDTO;
import com.api.innovation.application.orders.usecases.CreateOrderUseCase;
import com.api.innovation.infra.databases.hibernate.orders.models.Order;
import com.api.innovation.infra.handlers.exceptions.InternalServerErrorException;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/orders")
public class CreateOrderController {
    private final CreateOrderUseCase createOrderUseCase;

	public CreateOrderController(CreateOrderUseCase createOrderUseCase) {
		this.createOrderUseCase = createOrderUseCase;
	}

	@ApiResponses(value = {
        @ApiResponse(code = 201, message = "Recurso criado com sucesso"),
        @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @PostMapping
	public ResponseEntity<OrderDTO> execute(@RequestBody @Valid OrderCreateDTO orderCreateDTO) {
		try {
			Order createdOrder = createOrderUseCase.execute(orderCreateDTO);

			return ResponseEntity.status(HttpStatus.CREATED).body(
				(OrderDTO) new OrderDTO().convertToDTO(createdOrder)
			);
			
		} catch (Exception exception) {
            throw new InternalServerErrorException(exception.getMessage());
        }
	}
}
