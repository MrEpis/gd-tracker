package com.mrepis.gdtrackerback.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Demon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String creator;
    private Integer attempts;
    private Integer enjoyment;

    @Enumerated(EnumType.STRING)
    private Difficulty difficulty;

    private LocalDate completionDate;

    @Column(length = 1000)
    private String notes;
}
