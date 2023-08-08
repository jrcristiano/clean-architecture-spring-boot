package com.api.innovation.application.deliveries.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.api.innovation.infra.databases.hibernate.deliveries.models.Delivery;
import com.api.innovation.infra.databases.hibernate.deliveries.repositories.DeliveryRepository;
import com.api.innovation.infra.handlers.exceptions.EntityNotFoundErrorException;

@Service
public class GetDeliveryByIdService {
    private DeliveryRepository deliveryRepository;

    public GetDeliveryByIdService(DeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }

    public Optional<Delivery> execute(Long id) {
        Optional<Delivery> delivery = deliveryRepository.findById(id);
        if (!delivery.isPresent()) {
            throw new EntityNotFoundErrorException("Delivery ID " + id.toString() + " not found.");
        }

        return delivery;
    }
}
