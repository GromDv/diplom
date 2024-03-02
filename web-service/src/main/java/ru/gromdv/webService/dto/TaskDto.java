package ru.gromdv.webService.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import ru.gromdv.webService.model.TaskStatus;

import java.time.LocalDateTime;

@Data
public class TaskDto {
    private Long id;

    private String name;

    private String description;

    private TaskStatus status;

    private String statusGood;

    private LocalDateTime dateCreate;

    private String dateCreateGood;

    private LocalDateTime dateComplete;

    private String dateCompleteGood;
}
