package ru.gromdv.taskManager.controller;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.gromdv.taskManager.dto.*;
import ru.gromdv.taskManager.service.TaskServise;

import java.util.List;
import java.util.logging.Level;

@org.springframework.web.bind.annotation.RestController
@AllArgsConstructor
@Log
@RequestMapping("/tasks")
public class RestController {

    private final TaskServise servise;
    private final DtoMapper dtoMapper;

    @GetMapping("/list")
    public ResponseEntity<List<TaskDto>> getTasksList() {
        List<TaskDto> tasks = servise.getTasksList()
                .stream().map(dtoMapper::toDto).toList();
        log.log(Level.INFO, String.format("Tasks LIST: %s", tasks));

        return ResponseEntity.ok().body(tasks);
    }
}
