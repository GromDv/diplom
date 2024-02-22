package ru.gromdv.messageService.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import ru.gromdv.messageService.model.MessageStatus;


import java.time.LocalDateTime;

@Data
public class MessageDto {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    private Long taskId;

    private Long parentMessId;

    private String title;

    private String text;

    private MessageStatus status;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime dateCreate;
}
