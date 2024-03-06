package ru.gromdv.webService.dto;

import lombok.Data;

import java.util.List;

@Data

public class ListDto {
    List<TaskDto> tasksList;
}
