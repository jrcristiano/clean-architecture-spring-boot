package com.api.innovation.infra.databases.hibernate.deliveries.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.innovation.infra.databases.hibernate.deliveries.models.Delivery;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Long> {}
