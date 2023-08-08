package com.api.innovation.infra.databases.hibernate.deliveries.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.api.innovation.infra.databases.hibernate.orders.models.Order;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "deliveries")
@Getter
@Setter
public class Delivery {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "auto_increment_sequency")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @Column(name = "delivery_name", nullable = false, length = 128)
    private String deliveryName;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "created_at", updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;
    

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}