package com.api.innovation.application.deliveries.services;

import org.springframework.stereotype.Component;

import com.api.innovation.infra.databases.hibernate.deliveries.repositories.DeliveryRepository;

@Component
public class DeleteDeliveryByIdService {
    private DeliveryRepository deliveryRepository;
	private GetDeliveryByIdService getDeliveryByIdService;

	public DeleteDeliveryByIdService(
		DeliveryRepository deliveryRepository,
		GetDeliveryByIdService getDeliveryByIdService
	) {
		this.deliveryRepository = deliveryRepository;
		this.getDeliveryByIdService = getDeliveryByIdService;
	}

	public void execute(Long id) {
		getDeliveryByIdService.execute(id);
		deliveryRepository.deleteById(id);
	}
}
