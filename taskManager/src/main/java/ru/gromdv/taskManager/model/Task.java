package ru.gromdv.taskManager.model;

import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    @Column(name = "date_create")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private LocalDateTime dateCreate;

    @Column(name = "date_complete")
    private LocalDateTime dateComplete;
}
