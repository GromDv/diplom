package ru.gromdv.webService.controller;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.gromdv.webService.config.AppConfig;
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
    private final AppConfig appConfig;
    @Autowired
    private final TasksApiImpl tasksApi;

    @GetMapping
    public String getTasksList(Model model) {
        String urlApiTasks = "http://localhost:8087";
        String urlWeb = "http://localhost:8086";
        List<Task> tasks = tasksApi.getAllTasks();
        model.addAttribute("bcolor", "magenta");
        model.addAttribute("list", tasks);
        model.addAttribute("urlweb", urlWeb);
        model.addAttribute("urlApiTasks", urlApiTasks);
        log.log(Level.INFO, String.format("urlweb: %s", urlWeb));
        log.log(Level.INFO, String.format("urlApiTasks: %s", urlApiTasks));

        return "tasks.html";
    }
    @GetMapping("/tasks/{status}")
    public String getTasksByStatus(Model model, @PathVariable String status) {
        String bcolor = switch (status) {
            case "new" -> "yellow";
            case "progress" -> "blue";
            case "completed" -> "green";
            case "paused" -> "red";
            case "urgent" -> "orange";
            default -> "magenta";
        };
        String urlApiTasks = "http://localhost:8087";
        String urlWeb = "http://localhost:8086";
        List<Task> tasks = tasksApi.getTasksByStatus(status);
        model.addAttribute("bcolor", bcolor);
        model.addAttribute("list", tasks);
        model.addAttribute("urlweb", urlWeb);
        model.addAttribute("urlApiTasks", urlApiTasks);
        log.log(Level.INFO, String.format("urlweb: %s", urlWeb));
        log.log(Level.INFO, String.format("urlApiTasks: %s", urlApiTasks));

        return "tasks.html";
    }

    @GetMapping("/add")
    public String addNewTask(Model model) {
        String urlApiTasks = "http://localhost:8087";
        String urlWeb = "http://localhost:8086/tm/create";
        Task task = new Task();
        model.addAttribute("task", task);
        model.addAttribute("urlWeb", urlWeb);
        model.addAttribute("urlApi", urlApiTasks + "/tasks/api/add");
        return "create-task.html";
    }

    @PostMapping("/create")
    public String createTask(Task task) {
        tasksApi.createTask(task);
        return "redirect:/tm";
    }
}
