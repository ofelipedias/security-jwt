package com.spring.security.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "user_role")
public class UserRole {

    @Id
    @GeneratedValue
    private BigDecimal id;

    @OneToOne
    @JoinColumn(name = "id")
    private Role role;

    @Column(name = "dat_create")
    private LocalDateTime creationDate;

    @Column(name = "dat_update")
    private LocalDateTime updateDate;
}
