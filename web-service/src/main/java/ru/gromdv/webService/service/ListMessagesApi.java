package ru.gromdv.webService.service;

import lombok.Data;
import ru.gromdv.webService.dto.MessageDto;

import java.util.List;

@Data
public class ListMessagesApi {
    List<MessageDto> list;

}
