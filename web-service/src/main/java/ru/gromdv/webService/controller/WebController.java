package ru.gromdv.webService.controller;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.gromdv.webService.config.AppConfig;
import ru.gromdv.webService.dto.TaskDto;
import ru.gromdv.webService.dto.TaskGetDto;
import ru.gromdv.webService.model.Task;
import ru.gromdv.webService.model.User;
import ru.gromdv.webService.model.UserDto;
import ru.gromdv.webService.model.UserStatus;
import ru.gromdv.webService.service.TasksApiImpl;
import org.springframework.ui.Model;
import ru.gromdv.webService.service.UserApi;
import ru.gromdv.webService.service.UserApiImpl;

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
    @Autowired
    private final UserApiImpl userApi;

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
    public String createTask(TaskDto task) {
        tasksApi.createTask(task);
        return "redirect:/";
    }
    @GetMapping("/task/{id}")
    public String getTaskById(Model model, @PathVariable Long id) {
        TaskGetDto task = tasksApi.getTaskById(id);
        log.log(Level.INFO, String.format("Task: %s", task));
        model.addAttribute("task", task);
        return "task-view.html";
    }
    @GetMapping("/lk")
    public String showUserInfo(Model model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }
        User user = userApi.getByUsername(username);
        model.addAttribute("user", user);
        String urlWeb = appConfig.getHost()+ ":" + appConfig.getServerPort();
        model.addAttribute("urlWeb", urlWeb);
        return "personal.html";
    }
    @GetMapping("/list-dev")
    public String showDevUserList(Model model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }
        User user = userApi.getByUsername(username);
        List<User> list = userApi.getUserListByDevId(user.getDevId());
        model.addAttribute("list", list);
        return "users-list.html";
    }
    @GetMapping("/create-user")
    public String addUser(Model model) {
        String urlWeb = appConfig.getHost()+ ":" + appConfig.getServerPort() + "/create-user";
        model.addAttribute("urlWeb", urlWeb);
        return "create-user.html";
    }

    @PostMapping("/create-user")
    public String createUser(UserDto u) {
        User user = new User();
        user.setUsername(u.getUsername());
        user.setLastName(u.getLastName());
        user.setEMail(u.getEMail());
        user.setPassword(u.getPassword());
        user.setStatus(UserStatus.DEV);
        user.setDevId(0L);
        userApi.createUser(user);
        return "redirect:/lk";
    }
}
