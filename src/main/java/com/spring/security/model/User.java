package com.spring.security.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigDecimal id;

    private String name;

    private String password;

    @Column(name = "dat_create")
    private LocalDateTime creationDate;

    @Column(name = "dat_update")
    private LocalDateTime updateDate;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "id_user"),
            inverseJoinColumns = @JoinColumn(name = "id_role"))
    private List<Role> userRoles;

    @PrePersist
    private void prePersist() {
        this.password = new BCryptPasswordEncoder().encode(this.password);
        this.creationDate = LocalDateTime.now();
    }

}
