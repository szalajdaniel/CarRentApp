package com.example.carrent.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "report")
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name_of_submitter")
    private String name_of_submitter;

    @Column(name = "email")
    private String email;

    @Column(name = "subject")
    private String subject;

    @Column(name = "description")
    private String description;

    @Column(name = "is_resolved")
    private Boolean isResolved;
}
