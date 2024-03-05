package ru.gromdv.webService.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import ru.gromdv.webService.model.Task;
import ru.gromdv.webService.model.TaskStatus;

import java.time.LocalDateTime;

@Getter
@Setter
public class TaskUpdateDto {
    private Long id;

    private String name;

    private String description;

    private TaskStatus status;

    private LocalDateTime dateCreate;

    private LocalDateTime dateComplete;
    public TaskUpdateDto(Task t) {
        id = t.getId();
        name = t.getName();
        description = t.getDescription();
        status = t.getStatus();
        dateCreate = t.getDateCreate();
        if(t.getDateComplete() == null)
            dateComplete = t.getDateCreate();
        else
            dateComplete = t.getDateComplete();
    }
}
