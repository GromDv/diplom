package ru.gromdv.webService.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import ru.gromdv.webService.model.TaskStatus;

import java.time.LocalDateTime;

@Data
public class TaskDto {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    private String name;

    private String description;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private TaskStatus status;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime dateCreate;

    private LocalDateTime dateComplete;
}
