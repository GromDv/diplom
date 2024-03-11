package ru.gromdv.messageService.dto;

import lombok.Data;

import java.util.List;

@Data
public class ListUMDto {
    List<UserMessageDto> list;
}
