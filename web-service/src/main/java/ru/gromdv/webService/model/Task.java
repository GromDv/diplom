package ru.gromdv.webService.model;

import java.time.LocalDateTime;
import lombok.Data;


@Data
public class Task {

    private Long id;

    private String name;

    private String description;

    private TaskStatus status;

    private LocalDateTime dateCreate;

    private LocalDateTime dateComplete;
}