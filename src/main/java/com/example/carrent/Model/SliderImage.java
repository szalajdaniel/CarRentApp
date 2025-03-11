package com.example.carrent.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "slider_image")
public class SliderImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private byte[] image;
}