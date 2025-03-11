package com.example.carrent.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "moderator")
public class Moderator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private String role;
}