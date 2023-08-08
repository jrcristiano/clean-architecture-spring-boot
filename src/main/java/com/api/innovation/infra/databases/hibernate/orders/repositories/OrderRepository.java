package com.api.innovation.infra.databases.hibernate.orders.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.innovation.infra.databases.hibernate.orders.models.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {}
