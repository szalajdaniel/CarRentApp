package com.example.carrent.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long number;
    private String brand;
    private String carcategorry;

    @Lob
    private byte[] image;

    private boolean available;
}