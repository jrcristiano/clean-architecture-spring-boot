package com.api.innovation.application.deliveries.usecases;

import org.springframework.stereotype.Component;

import com.api.innovation.application.deliveries.services.DeleteDeliveryByIdService;
import com.api.innovation.infra.databases.hibernate.deliveries.repositories.DeliveryRepository;

@Component
public class DeleteDeliveryByIdUseCase {
    private DeliveryRepository deliveryRepository;
    private DeleteDeliveryByIdService deleteDeliveryByIdService;

	public DeleteDeliveryByIdUseCase(
		DeliveryRepository deliveryRepository,
        DeleteDeliveryByIdService deleteDeliveryByIdService
	) {
		this.deliveryRepository = deliveryRepository;
        this.deleteDeliveryByIdService = deleteDeliveryByIdService;
	}

	public void execute(Long id) {
		deleteDeliveryByIdService.execute(id);
	}
}
