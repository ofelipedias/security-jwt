package com.spring.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.spring.security.repository")
@Configuration
public class JpaRepositoryConfig {
}
