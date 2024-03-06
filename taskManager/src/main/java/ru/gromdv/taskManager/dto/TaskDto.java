package ru.gromdv.taskManager.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import ru.gromdv.taskManager.model.TaskStatus;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
public class TaskDto {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    private Long authorId;

    private String name;

    private String description;

    private TaskStatus status;

    private String statusGood;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime dateCreate;

    private String dateCreateGood;

    private LocalDateTime dateComplete;

    private String dateCompleteGood;

    public void setStatusGood(TaskStatus status) {
        statusGood = status.getTitle();
//        statusGood = switch (status) {
//            case NEW_TASK -> "Новая";
//            case IN_PROGRESS -> "В работе";
//            case COMPLETED -> "Выполнена";
//            case PAUSED -> "Остановлена";
//            case URGENT -> "Срочная";
//            case CANCELED -> "Отменена";
//            default -> "не определен";
//        };
    }
//    public String getStatusGood() {
//        return switch (status) {
//            case NEW_TASK -> "Новая";
//            case IN_PROGRESS -> "В работе";
//            case COMPLETED -> "Выполнена";
//            case PAUSED -> "Остановлена";
//            case URGENT -> "Срочная";
//            case CANCELED -> "Отменена";
//            default -> "не определен";
//        };
//    }
//    public String getDateCreateGood() {
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm dd-MM-yyyy");
//        return dateCreate.format(formatter);
//    }
    public void setDateCreateGood(LocalDateTime dt) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm dd-MM-yyyy");
        dateCreateGood = dt.format(formatter);
    }
//    public String getDateCompleteGood() {
//        if(dateComplete != null) {
//            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
//            return dateComplete.format(formatter);
//        } else {
//            return "-";
//        }
//    }
    public void setDateCompleteGood(LocalDateTime dt) {
        if(dt != null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm dd-MM-yyyy");
            dateCompleteGood = dt.format(formatter);
        } else {
            dateCompleteGood = "-";
        }
    }
}
