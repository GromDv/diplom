package ru.gromdv.webService.model;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

import java.time.LocalDateTime;


@Data
public class Task {

    private Long id;

    private Long authorId;

    private Long developerId;

    private String name;

    private String description;

    private TaskStatus status;

    private LocalDateTime dateCreate;

    private LocalDateTime dateComplete;

    private int takes;
}