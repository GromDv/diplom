package ru.gromdv.taskManager.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import ru.gromdv.taskManager.model.TaskStatus;

import java.time.LocalDateTime;

@Data
public class TaskDto {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    private String name;

    private String description;

    private TaskStatus status;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime dateCreate;

    private LocalDateTime dateComplete;
}
