package com.api.innovation.application.deliveries.services;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.api.innovation.application.deliveries.dto.requests.DeliveryCreateDTO;
import com.api.innovation.application.orders.usecases.GetOrderByIdUseCase;
import com.api.innovation.infra.databases.hibernate.deliveries.models.Delivery;
import com.api.innovation.infra.databases.hibernate.deliveries.repositories.DeliveryRepository;
import com.api.innovation.infra.databases.hibernate.orders.models.Order;
import com.api.innovation.infra.handlers.exceptions.ConflictErrorException;

@Component
public class CreateDeliveryService {
    private final DeliveryRepository deliveryRepository;
    private final GetOrderByIdUseCase getOrderByIdUseCase;

    public CreateDeliveryService(
        DeliveryRepository deliveryRepository, 
        GetOrderByIdUseCase getOrderByIdUseCase
    ) {
        this.deliveryRepository = deliveryRepository;
        this.getOrderByIdUseCase = getOrderByIdUseCase;
    }

    public Delivery execute(DeliveryCreateDTO deliveryCreateDTO) {
        Optional<Delivery> registeredDelivery = deliveryRepository.findById(deliveryCreateDTO.getOrder());

        if (registeredDelivery.isPresent()) {
            throw new ConflictErrorException("Delivery address already exists.");
        }

        Order order = getOrderByIdUseCase.execute(deliveryCreateDTO.getOrder());

        com.api.innovation.domain.deliveries.entities.Delivery deliveryEntity = new com.api.innovation.domain.deliveries.entities.Delivery(
            deliveryCreateDTO.getId(),
            deliveryCreateDTO.getStatus(),
            deliveryCreateDTO.getOrder(),
            deliveryCreateDTO.getDeliveryName(),
            null,
            null
        );

        Delivery delivery = new Delivery();
        delivery.setOrder(order);

        BeanUtils.copyProperties(deliveryEntity, delivery);

        return deliveryRepository.save(delivery);
    }
}
