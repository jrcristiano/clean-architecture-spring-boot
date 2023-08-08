package com.api.innovation.presentation.controllers.deliveries;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.innovation.application.deliveries.dto.requests.DeliveryRequestDTO;
import com.api.innovation.application.deliveries.dto.requests.DeliveryUpdateDTO;
import com.api.innovation.application.deliveries.usecases.UpdateDeliveryByIdUseCase;
import com.api.innovation.infra.databases.hibernate.deliveries.models.Delivery;
import com.api.innovation.infra.handlers.exceptions.InternalServerErrorException;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/deliveries")
public class UpdateDeliveryByIdController {
    private final UpdateDeliveryByIdUseCase updateDeliveryByIdUseCase;

    public UpdateDeliveryByIdController(UpdateDeliveryByIdUseCase updateDeliveryByIdUseCase) {
        this.updateDeliveryByIdUseCase = updateDeliveryByIdUseCase;
    }

    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Recurso atualizado com sucesso"),
        @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @PutMapping("/{id}")
    public ResponseEntity<DeliveryRequestDTO> execute(
        @PathVariable("id") Long id, @RequestBody @Valid DeliveryUpdateDTO deliveryUpdateDTO
    ) {
        try {
            Delivery updatedDelivery = updateDeliveryByIdUseCase.execute(id, deliveryUpdateDTO);

            return ResponseEntity.status(HttpStatus.OK).body(
                (DeliveryRequestDTO) new DeliveryUpdateDTO().convertToDTO(updatedDelivery)
            );
            
        } catch (Exception exception) {
            throw new InternalServerErrorException(exception.getMessage());
        }
    }
}
