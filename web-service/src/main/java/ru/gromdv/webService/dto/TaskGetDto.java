package ru.gromdv.webService.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
public class TaskGetDto {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    private String name;

    private String description;

    private String status;

    private String statusGood;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime dateCreate;

    private String dateCreateGood;

    private LocalDateTime dateComplete;

    private String dateCompleteGood;
}
