package ru.gromdv.webService.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MessageCreateDto {
    private Long taskId;
    private Long userId;
    private Long parentMessId;
    private String title;
    private String text;
}
