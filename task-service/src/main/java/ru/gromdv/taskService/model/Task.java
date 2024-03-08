package ru.gromdv.taskService.model;

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

    @Column(name = "author_id")
    private Long authorId;

    @Column(name = "developer_id")
    private Long developerId;

    private String name;

    private String description;

    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    @Column(name = "date_create")
    private LocalDateTime dateCreate;

    @Column(name = "date_complete")
    private LocalDateTime dateComplete;

    private int takes;
}
