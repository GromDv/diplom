package ru.gromdv.webService.dto;

import lombok.Data;

@Data
public class TaskDto {

    private String name;

    private Long authorId;

    private Long developerId;

    private String description;
}
