package com.api.innovation.infra.databases.hibernate.clients.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.api.innovation.infra.databases.hibernate.clients.models.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    @Query(value = "select * from clients where email = :email", nativeQuery = true)
	Optional<Client> findClientByEmail(@Param("email") String email);
}
