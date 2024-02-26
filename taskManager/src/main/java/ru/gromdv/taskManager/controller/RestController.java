package ru.gromdv.taskManager.controller;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.gromdv.taskManager.dto.DtoMapper;
import ru.gromdv.taskManager.dto.TaskDto;
import ru.gromdv.taskManager.model.Task;
import ru.gromdv.taskManager.service.TaskService;

import java.util.List;
import java.util.logging.Level;

@org.springframework.web.bind.annotation.RestController
@AllArgsConstructor
@Log
@RequestMapping("/tasks/api")
public class RestController {

    private final TaskService servise;
    private final DtoMapper dtoMapper;

    @GetMapping("/list")
    public ResponseEntity<List<TaskDto>> getTasksList() {
        List<TaskDto> tasks = servise.getTasksList()
                .stream().map(dtoMapper::toDto).toList();
//        log.log(Level.INFO, String.format("Tasks LIST: %s", tasks));
        return ResponseEntity.ok().body(tasks);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addNewTask(@RequestBody Task t) {
        servise.addNewTask(t);
        return ResponseEntity.ok().body(t);
    }
}
