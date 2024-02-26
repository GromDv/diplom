package ru.gromdv.taskManager.controller;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.gromdv.taskManager.model.Task;
import ru.gromdv.taskManager.dto.DtoMapper;
import ru.gromdv.taskManager.service.TaskService;

import java.util.List;
import java.util.logging.Level;

@Log
@Controller
@AllArgsConstructor
@RequestMapping("/tasks")
public class WebController {
    @Autowired
    private final TaskService service;
    @Autowired
    private final DtoMapper dtoMapper;

    @GetMapping("/list")
    public List<Task> getTasksList() {
        List<Task> tasks = service.getTasksList();
        log.log(Level.INFO, String.format("WebTasks LIST: %s", tasks));

        return tasks;
    }
}
