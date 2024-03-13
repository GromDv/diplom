package ru.gromdv.webService.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class UserMessDTOWithChildMess {
    private Long id;
    private Long taskId;
    private Long userId;
    private Long parentMessId;
    private Long numMess;
    private String title;
    private String text;
    private String status;
    private LocalDateTime dateCreate;
    private String username;
    private List<UserMessDTOWithChildMess> listChildMess;
}
