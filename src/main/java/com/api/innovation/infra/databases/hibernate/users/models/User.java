package com.api.innovation.infra.databases.hibernate.users.models;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User implements Serializable {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "auto_increment_sequency")
	private Long id;

	@Column(name = "name", nullable = false, length = 32)
	private String name;

	@Column(name = "lastname", nullable = false, length = 128)
	private String lastname;

	@Column(name = "email", nullable = false, length = 255, unique = true)
	private String email;

	@Column(name = "password", nullable = false, length = 255)
	private String password;

	@Column(name = "created_at", updatable = false)
	@CreationTimestamp
	private LocalDateTime createdAt;

	@UpdateTimestamp
	@Column(name = "updated_at")
	private LocalDateTime updatedAt;
}
