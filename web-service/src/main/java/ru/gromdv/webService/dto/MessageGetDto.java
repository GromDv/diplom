package ru.gromdv.webService.dto;

import lombok.Data;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
public class MessageGetDto {

    private Long id;

    private Long taskId;

    private Long parentMessId;

    private String title;

    private String text;

    private MessageStatus status;

    private LocalDateTime dateCreate;

    private String dateCreateFormatted;

    public MessageGetDto(MessageDto m) {
        id = m.getId();
        taskId = m.getTaskId();
        parentMessId = m.getParentMessId();
        title = m.getTitle();
        text = m.getText();
        status = m.getStatus();
        dateCreate = m.getDateCreate();
        setDateCreateFormatted();
    }

    public void setDateCreateFormatted() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm dd-MM-yyyy");
        dateCreateFormatted = dateCreate.format(formatter);
    }
}
