package ru.gromdv.webService.dto;

import lombok.Data;

import java.util.List;

@Data
public class ListUMDto {
    List<UserMessageDto> list;
}
