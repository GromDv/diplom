package ru.gromdv.messageService.controller;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gromdv.messageService.dto.DtoMapper;
import ru.gromdv.messageService.dto.MessageDto;
import ru.gromdv.messageService.dto.UserMessageDto;
import ru.gromdv.messageService.model.Message;
import ru.gromdv.messageService.service.MessageService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Level;

@org.springframework.web.bind.annotation.RestController
@AllArgsConstructor
@Log
@RequestMapping("/messages")
public class RestController {

    private final MessageService servise;
    private final DtoMapper dtoMapper;

    @GetMapping("/list")
    public ResponseEntity<List<Message>> getFullList() {
        List<Message> list = servise.getMessList();
        log.log(Level.INFO, String.format("LIST mess: %s", list));

        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<List<Message>> getListMessagesByTaskId(@PathVariable Long id) {
        List<Message> list = servise.getListByTaskId(id);
        log.log(Level.INFO, String.format("LIST mess: %s", list));

        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/list-u/{id}")
    public ResponseEntity<List<UserMessageDto>> getListMessagesByTaskIdWithUsers(@PathVariable Long id) {
        List<?> inList = servise.getListByTaskIdWithUsers(id);
        List<UserMessageDto> list = inList.stream().map(x -> DtoMapper.toUserMessageDto((Object[])x)).toList();
        log.log(Level.INFO, String.format("LIST mess: %s", list));

        return ResponseEntity.ok().body(list);
    }
    @PostMapping("/create/{taskId}/{userId}")
    public ResponseEntity<?> createMessage(@RequestBody Message message,
                                           @PathVariable Long taskId, @PathVariable Long userId) {
        message.setDateCreate(LocalDateTime.now());
        message.setTaskId(taskId);
        message.setUserId(userId);
        servise.createMessage(message);
        return ResponseEntity.ok().body(message);
    }
}
