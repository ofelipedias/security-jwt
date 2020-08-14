package com.spring.security.repository;

import com.spring.security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, BigDecimal> {

    Optional<User> findByName(String name);
}
