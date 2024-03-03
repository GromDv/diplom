package ru.gromdv.webService.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


@Data
public class Task {

    private Long id;

    private String name;

    private String description;

    private TaskStatus status;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime dateCreate;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
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