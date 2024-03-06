package ru.gromdv.webService.model;

import lombok.Data;

import java.time.LocalDateTime;


@Data
public class Task {

    private Long id;

    private Long authorId;

    private String name;

    private String description;

    private TaskStatus status;

    private LocalDateTime dateCreate;

    private LocalDateTime dateComplete;

    private int takes;
}