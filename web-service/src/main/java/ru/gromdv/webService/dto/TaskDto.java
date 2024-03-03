package ru.gromdv.webService.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import ru.gromdv.webService.model.TaskStatus;

import java.time.LocalDateTime;

@Data
public class TaskDto {
    private String name;

    private String description;
}
