package com.api.innovation.infra.databases.hibernate.users.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.api.innovation.infra.databases.hibernate.users.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "select * from users where email = :email", nativeQuery = true)
	Optional<User> findUserByEmail(@Param("email") String email);
}
