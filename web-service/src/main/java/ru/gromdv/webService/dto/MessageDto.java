package ru.gromdv.webService.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MessageDto {
    private Long id;

    private Long taskId;

    private Long parentMessId;

    private String title;

    private String text;

    private MessageStatus status;

    private LocalDateTime dateCreate;
}
