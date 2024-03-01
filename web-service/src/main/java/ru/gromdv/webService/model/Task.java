package ru.gromdv.webService.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import lombok.Data;


@Data
public class Task {

    private Long id;

    private String name;

    private String description;

    private TaskStatus status;

    private LocalDateTime dateCreate;

    private LocalDateTime dateComplete;

    public String getGoodDateCreate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm dd-MM-yyyy");
        return dateCreate.format(formatter);
    }
    public String getGoodDateComplete() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return dateComplete.format(formatter);
    }
}