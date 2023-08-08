package com.api.innovation.presentation.controllers.orders;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.innovation.application.orders.dto.responses.OrderDTO;
import com.api.innovation.application.orders.usecases.GetOrdersPaginateUseCase;
import com.api.innovation.infra.databases.hibernate.orders.models.Order;
import com.api.innovation.infra.handlers.exceptions.InternalServerErrorException;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/orders")
public class GetOrdersPaginateController {

    private final GetOrdersPaginateUseCase getOrdersPaginateUseCase;

	public GetOrdersPaginateController(GetOrdersPaginateUseCase getOrdersPaginateUseCase) {
		this.getOrdersPaginateUseCase = getOrdersPaginateUseCase;
	}
    
	@ApiResponses(value = {
        @ApiResponse(code = 200, message = "Retorna a lista de dados"),
    })
    @GetMapping
	public Page<OrderDTO> execute(
		@RequestParam(name = "page", required = false, defaultValue = "1") String page,
		@RequestParam(name = "limit", required = false, defaultValue = "10") String limit,
		@RequestParam(name = "orderBy", required = false, defaultValue = "desc") String orderBy,
		@RequestParam(name = "sortBy", required = false, defaultValue = "createdAt") String sortBy
	) {
		try {
			Page<Order> orders = getOrdersPaginateUseCase.execute(
				page,
				limit,
				orderBy,
				sortBy
			);

			return orders.map(order -> new OrderDTO().convertToDTO(order));
			
		} catch (Exception exception) {
            throw new InternalServerErrorException(exception.getMessage());
        }
	}
}
