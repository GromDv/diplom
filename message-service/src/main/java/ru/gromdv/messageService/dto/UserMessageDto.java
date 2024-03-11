package ru.gromdv.messageService.dto;

import jakarta.persistence.Column;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserMessageDto {
    private Long id;
    @Column(name = "task_id")
    private Long taskId;
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "parent_mess_id")
    private Long parentMessId;
    @Column(name = "num_mess")
    private Long numMess;
    private String title;
    private String text;
    private String status;
    @Column(name = "date_create")
    private LocalDateTime dateCreate;
    private String username;
}
