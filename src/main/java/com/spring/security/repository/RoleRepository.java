package com.spring.security.repository;

import com.spring.security.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;

public interface RoleRepository extends JpaRepository<Role, BigDecimal> {

}
