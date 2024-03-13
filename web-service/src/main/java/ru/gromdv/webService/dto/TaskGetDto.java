package ru.gromdv.webService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.gromdv.webService.model.Task;
import ru.gromdv.webService.model.TaskStatus;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskGetDto {

    private Long id;

    private Long authorId;

    private Long developerId;

    private String name;

    private String description;

    private TaskStatus status;

    private String statusGood;

    private LocalDateTime dateCreate;

    private String dateCreateFormatted;

    private LocalDateTime dateComplete;

    private String dateCompleteFormatted;

    public TaskGetDto(Task t) {
        id = t.getId();
        authorId = t.getAuthorId();
        developerId = t.getDeveloperId();
        name = t.getName();
        description = t.getDescription();
        status = t.getStatus();
        dateCreate = t.getDateCreate();
        dateComplete = t.getDateComplete();
        setDateCreateFormatted();
        setDateCompleteFormatted();
    }

    public void setDateCreateFormatted() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm dd-MM-yyyy");
        dateCreateFormatted = dateCreate.format(formatter);
    }
    public void setDateCompleteFormatted() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm dd-MM-yyyy");
        if(dateComplete != null)
            dateCompleteFormatted =  dateComplete.format(formatter);
        else
            dateCompleteFormatted = "-";
    }

}
