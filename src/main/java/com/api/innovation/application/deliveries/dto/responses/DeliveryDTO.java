package com.api.innovation.application.deliveries.dto.responses;

import com.api.innovation.application.clients.dto.responses.ClientDTO;
import com.api.innovation.application.orders.dto.responses.OrderDTO;
import com.api.innovation.infra.databases.hibernate.clients.models.Client;
import com.api.innovation.infra.databases.hibernate.deliveries.models.Delivery;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class DeliveryDTO {
    protected Long id;

    protected OrderDTO order;

    protected String status;

    private String deliveryName;

    protected ClientDTO client;

    protected LocalDateTime createdAt;
    
    public DeliveryDTO() {

    }

    public DeliveryDTO convertToDTO(Delivery delivery) {
        this.setId(delivery.getId());
        
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId(delivery.getOrder().getId());
        orderDTO.setProductName(delivery.getOrder().getProductName());
        orderDTO.setPrice(delivery.getOrder().getPrice());
        orderDTO.setCreatedAt(delivery.getOrder().getCreatedAt());
        orderDTO.setUpdatedAt(delivery.getOrder().getUpdatedAt());

        // Set other properties of orderDTO based on delivery.getOrder()
        this.setOrder(orderDTO);

        Client orderClient = delivery.getOrder().getClient();

        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setId(orderClient.getId());
        clientDTO.setName(orderClient.getName());
        clientDTO.setLastname(orderClient.getLastname());
        clientDTO.setCpf(orderClient.getCpf());
        clientDTO.setEmail(orderClient.getEmail());
        clientDTO.setAddress(orderClient.getAddress());
        clientDTO.setPhone(orderClient.getPhone());
        clientDTO.setAddress(orderClient.getAddress());
        clientDTO.setCreatedAt(orderClient.getCreatedAt());
        
        
        this.setDeliveryName(delivery.getDeliveryName());
        this.setStatus(delivery.getStatus());
        this.setClient(clientDTO);
        this.setCreatedAt(delivery.getCreatedAt());

        return this;
    }
}
