package com.api.innovation.application.deliveries.services;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.api.innovation.application.deliveries.dto.requests.DeliveryUpdateDTO;
import com.api.innovation.infra.databases.hibernate.deliveries.models.Delivery;
import com.api.innovation.infra.databases.hibernate.deliveries.repositories.DeliveryRepository;

@Service
public class UpdateDeliveryByIdService {
	private final DeliveryRepository deliveryRepository;
	private final GetDeliveryByIdService getDeliveryByIdService;

	public UpdateDeliveryByIdService(
		DeliveryRepository deliveryRepository,
		GetDeliveryByIdService getDeliveryByIdService
	) {
		this.deliveryRepository = deliveryRepository;
		this.getDeliveryByIdService = getDeliveryByIdService;
	}

	public Delivery execute(Long id, DeliveryUpdateDTO deliveryUpdateDTO) {
		deliveryUpdateDTO.setId(id);

		com.api.innovation.domain.deliveries.entities.Delivery deliveryEntity = new com.api.innovation.domain.deliveries.entities.Delivery(
            deliveryUpdateDTO.getId(),
            deliveryUpdateDTO.getStatus(),
            deliveryUpdateDTO.getOrder(),
            deliveryUpdateDTO.getDeliveryName(),
            null,
            null
        );

		Delivery delivery = getDeliveryByIdService.execute(id).get();
		BeanUtils.copyProperties(deliveryEntity, delivery);

		return deliveryRepository.save(delivery);
	}
}