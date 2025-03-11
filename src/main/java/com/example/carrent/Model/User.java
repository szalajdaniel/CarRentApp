package com.example.carrent.Model;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "app_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String role;

    @Transient
    private String rawPassword;

    @Column(columnDefinition = "DECIMAL(10,2) DEFAULT 0.0")
    private BigDecimal wallet;
}
