package com.api.innovation.presentation.controllers.deliveries;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.innovation.application.deliveries.dto.responses.DeliveryDTO;
import com.api.innovation.application.deliveries.usecases.GetDeliveriesPaginateUseCase;
import com.api.innovation.infra.databases.hibernate.deliveries.models.Delivery;
import com.api.innovation.infra.handlers.exceptions.InternalServerErrorException;

@RestController
@RequestMapping("/api/deliveries")
public class GetDeliveriesPaginateController {
    private GetDeliveriesPaginateUseCase getDeliveriesPaginateUseCase;

    public GetDeliveriesPaginateController(GetDeliveriesPaginateUseCase getDeliveriesPaginateUseCase) {
        this.getDeliveriesPaginateUseCase = getDeliveriesPaginateUseCase;
    }

    @GetMapping
    public Page<DeliveryDTO> execute(
            @RequestParam(name = "page", required = false, defaultValue = "1") String page,
            @RequestParam(name = "limit", required = false, defaultValue = "10") String limit,
            @RequestParam(name = "orderBy", required = false, defaultValue = "desc") String orderBy,
            @RequestParam(name = "sortBy", required = false, defaultValue = "createdAt") String sortBy
    ) {
        try {
            Page<Delivery> deliveries = getDeliveriesPaginateUseCase.execute(
                page,
                limit,
                orderBy,
                sortBy
            );

            return deliveries.map(delivery -> new DeliveryDTO().convertToDTO(delivery));

        } catch (Exception exception) {
            throw new InternalServerErrorException(exception.getMessage());
        }
    }
}
