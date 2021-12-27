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
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue
    private BigDecimal id;

    private String name;

    private String password;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_user")
    private List<UserRole> userRoles;

    @Column(name = "dat_create")
    private LocalDateTime creationDate;

    @Column(name = "dat_update")
    private LocalDateTime updateDate;
}
