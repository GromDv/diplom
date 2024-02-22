package ru.gromdv.messageService.controller;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import ru.gromdv.messageService.dto.DtoMapper;
import ru.gromdv.messageService.dto.MessageDto;
import ru.gromdv.messageService.service.MessageService;

import java.util.List;
import java.util.logging.Level;

@org.springframework.web.bind.annotation.RestController
@AllArgsConstructor
@Log
public class RestController {

    private final MessageService servise;
    private final DtoMapper dtoMapper;

    @GetMapping("/list")
    public ResponseEntity<List<MessageDto>> getTasksList() {
        List<MessageDto> tasks = servise.getMessList()
                .stream().map(dtoMapper::toDto).toList();
        log.log(Level.INFO, String.format("LIST: %s", tasks));

        return ResponseEntity.ok().body(tasks);
    }
}
