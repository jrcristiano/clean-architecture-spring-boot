package com.api.innovation.presentation.controllers.deliveries;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.innovation.application.deliveries.dto.responses.DeliveryDTO;
import com.api.innovation.application.deliveries.dto.requests.DeliveryCreateDTO;
import com.api.innovation.application.deliveries.usecases.CreateDeliveryUseCase;
import com.api.innovation.infra.databases.hibernate.deliveries.models.Delivery;
import com.api.innovation.infra.handlers.exceptions.InternalServerErrorException;

@RestController
@RequestMapping("/api/deliveries")
public class CreateDeliveryController {
    private final CreateDeliveryUseCase createDeliveryUseCase;

	public CreateDeliveryController(CreateDeliveryUseCase createDeliveryUseCase) {
		this.createDeliveryUseCase = createDeliveryUseCase;
	}

    @PostMapping
	public ResponseEntity<DeliveryDTO> execute(@RequestBody @Valid DeliveryCreateDTO deliveryCreateDTO) {
		try {
			Delivery createdDelivery = createDeliveryUseCase.execute(deliveryCreateDTO);

			return ResponseEntity.status(HttpStatus.CREATED).body(
				(DeliveryDTO) new DeliveryDTO().convertToDTO(createdDelivery)
			);
			
		} catch (Exception exception) {
            throw new InternalServerErrorException(exception.getMessage());
        }
	}
}