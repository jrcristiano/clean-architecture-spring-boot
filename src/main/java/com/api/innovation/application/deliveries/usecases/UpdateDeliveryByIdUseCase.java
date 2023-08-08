package com.api.innovation.application.deliveries.usecases;

import org.springframework.stereotype.Component;

import com.api.innovation.application.deliveries.dto.requests.DeliveryUpdateDTO;
import com.api.innovation.application.deliveries.services.UpdateDeliveryByIdService;
import com.api.innovation.infra.databases.hibernate.deliveries.models.Delivery;

@Component
public class UpdateDeliveryByIdUseCase {

    private final UpdateDeliveryByIdService updateDeliveryByIdService;

    public UpdateDeliveryByIdUseCase(UpdateDeliveryByIdService updateDeliveryByIdService) {
        this.updateDeliveryByIdService = updateDeliveryByIdService;
    }

    public Delivery execute(Long id, DeliveryUpdateDTO deliveryUpdateDTO) {
        return updateDeliveryByIdService.execute(id, deliveryUpdateDTO);
    }
}