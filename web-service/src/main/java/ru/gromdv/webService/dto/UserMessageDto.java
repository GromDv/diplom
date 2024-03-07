package ru.gromdv.webService.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserMessageDto {
    private Long id;
    private Long taskId;
    private Long userId;
    private Long parentMessId;
    private String title;
    private String text;
    private String status;
    private LocalDateTime dateCreate;
    private String username;
}
