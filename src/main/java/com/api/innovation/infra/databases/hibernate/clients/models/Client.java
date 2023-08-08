package com.api.innovation.infra.databases.hibernate.clients.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.api.innovation.infra.databases.hibernate.orders.models.Order;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Table(name = "clients")
@Getter
@Setter
@Entity
public class Client implements Serializable {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "auto_increment_sequency")
	private Long id;

	@Column(name = "name", nullable = false, length = 64)
	private String name;

	@Column(name = "lastname", nullable = false, length = 64)
	private String lastname;

	@Column(name = "email", nullable = false, length = 128, unique = true)
	private String email;

	@Column(name = "cpf", nullable = false, length = 16, unique = true)
	private String cpf;

	@Column(name = "phone", nullable = false, length = 16, unique = true)
	private String phone;

	@Column(name = "address", nullable = false, length = 255)
	private String address;

	@OneToMany(mappedBy = "client")
    private List<Order> orders;

	@Column(name = "created_at", updatable = false)
	@CreationTimestamp
	private LocalDateTime createdAt;

	@UpdateTimestamp
	@Column(name = "updated_at")
	private LocalDateTime updatedAt;
}
