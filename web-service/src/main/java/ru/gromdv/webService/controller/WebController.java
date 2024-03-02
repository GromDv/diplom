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
import ru.gromdv.webService.dto.TaskDto;
import ru.gromdv.webService.model.Task;
import ru.gromdv.webService.service.TasksApiImpl;
import org.springframework.ui.Model;

import java.util.List;
import java.util.logging.Level;

@Log
@Controller
@AllArgsConstructor
public class WebController {
    @Autowired
    private final AppConfig appConfig;
    @Autowired
    private final TasksApiImpl tasksApi;

    @GetMapping("/")
    public String getTasksList(Model model) {
        List<Task> tasks = tasksApi.getAllTasks();

        String urlWeb = appConfig.getHost()+ ":" + appConfig.getServerPort();
        log.log(Level.INFO, String.format("urlWebService: %s", urlWeb));
        model.addAttribute("bcolor", "magenta");
        model.addAttribute("list", tasks);
        model.addAttribute("status", "all");
        model.addAttribute("urlweb", urlWeb);
        log.log(Level.INFO, String.format("urlweb: %s", urlWeb));

        return "tasks.html";
    }
    @GetMapping("/tasks/{status}")
    public String getTasksByStatus(Model model, @PathVariable String status) {
        List<Task> tasks = tasksApi.getTasksByStatus(status);

        String bcolor = switch (status) {
            case "new" -> "yellow";
            case "progress" -> "blue";
            case "completed" -> "green";
            case "paused" -> "red";
            case "urgent" -> "orange";
            default -> "magenta";
        };
        String urlWeb = appConfig.getHost()+ ":" + appConfig.getServerPort();
        model.addAttribute("bcolor", bcolor);
        model.addAttribute("status", status);
        model.addAttribute("list", tasks);
        model.addAttribute("urlweb", urlWeb);
        log.log(Level.INFO, String.format("urlweb: %s", urlWeb));

        return "tasks.html";
    }

    @GetMapping("/add")
    public String addNewTask(Model model) {
        String urlApiTasks = appConfig.getHost()+appConfig.getGatewayPort();
        String urlWeb = appConfig.getHost()+ ":" + appConfig.getServerPort() + "/create";
        Task task = new Task();
        model.addAttribute("task", task);
        model.addAttribute("urlWeb", urlWeb);
        model.addAttribute("urlApi", urlApiTasks + "/tasks/api/add");
        return "create-task.html";
    }

    @PostMapping("/create")
    public String createTask(Task task) {
        tasksApi.createTask(task);
        return "redirect:/";
    }
    @GetMapping("/task/{id}")
    public String getTaskById(Model model, @PathVariable Long id) {
        TaskDto task = tasksApi.getTaskById(id);
        log.log(Level.INFO, String.format("Task: %s", task));
        model.addAttribute("task", task);
        return "task-view.html";
    }

}
