package ru.gromdv.messageService.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import lombok.Data;

import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class UserMessageDto {
    private Long id;
    @Column(name = "task_id")
    private Long taskId;
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "parent_mess_id")
    private Long parentMessId;
    private String title;
    private String text;
    private String status;
    @Column(name = "date_create")
    private LocalDateTime dateCreate;
    private String username;

//    public UserMessageDto(UserMessageDto in) {
//        id = in.getId();
//        taskId = in.getTaskId();
//        userId = in.getUserId();
//        parentMessId = in.getParentMessId();
//        title = in.getTitle();
//        text = in.getText();
//        status = in.getStatus();
//        dateCreate = in.getDateCreate();
//        username = in.getUsername();
//    }

}
