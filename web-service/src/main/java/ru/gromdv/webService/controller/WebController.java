package ru.gromdv.webService.controller;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.gromdv.webService.dto.DtoMapper;
import ru.gromdv.webService.model.Task;
import ru.gromdv.webService.service.TasksApiImpl;
import org.springframework.ui.Model;

import java.util.List;
import java.util.logging.Level;

@Log
@Controller
@AllArgsConstructor
@RequestMapping("/tm")
public class WebController {
    @Autowired
    private final TasksApiImpl tasksApi;

    @GetMapping
    public String getTasksList(Model model) {
        List<Task> tasks = tasksApi.getAllTasks();
        model.addAttribute("list", tasks);
        log.log(Level.INFO, String.format("WebTasks LIST: %s", tasks));

        return "tasks.html";
    }
}
