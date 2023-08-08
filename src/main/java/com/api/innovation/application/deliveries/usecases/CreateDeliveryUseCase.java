package com.api.innovation.application.deliveries.usecases;

import com.api.innovation.application.deliveries.services.CreateDeliveryService;
import com.api.innovation.infra.databases.hibernate.deliveries.models.Delivery;
import com.api.innovation.application.deliveries.dto.requests.DeliveryCreateDTO;

import org.springframework.stereotype.Component;

@Component
public class CreateDeliveryUseCase {
    private final CreateDeliveryService createDeliveryService;

    public CreateDeliveryUseCase(CreateDeliveryService createDeliveryService) {
        this.createDeliveryService = createDeliveryService;
    }

    public Delivery execute(DeliveryCreateDTO deliveryCreateDTO) {
        return createDeliveryService.execute(deliveryCreateDTO);
    }
}
