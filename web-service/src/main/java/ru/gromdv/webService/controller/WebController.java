package ru.gromdv.webService.controller;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.gromdv.webService.config.AppConfig;
import ru.gromdv.webService.dto.*;
import ru.gromdv.webService.model.*;
import ru.gromdv.webService.service.*;

import java.util.List;

@Log
@Controller
@AllArgsConstructor
public class WebController {

    private final AppConfig appConfig;
    private final TasksApiImpl tasksApi;
    private final UserApiImpl userApi;
    private final MessagesApi messApi;

    /**
     * Главная страница списка задач разработчика
     * @param model
     * @return
     */
    @GetMapping("/")
    public String getDeveloperTasksList(Model model) {
        User currUser = getCurrentUser();
        List<Task> tasks = tasksApi.getAllTasksByDeveloperId(currUser.getId());

        String urlWeb = appConfig.getHost()+ ":" + appConfig.getServerPort();
        model.addAttribute("bcolor", "magenta");
        model.addAttribute("list", tasks);
        model.addAttribute("status", "all");
        model.addAttribute("urlweb", urlWeb);

        return "tasks.html";
    }

    /**
     * Страница списка задач по статусу
     * @param model
     * @param status
     * @return
     */
    @GetMapping("/tasks/{status}")
    public String getTasksByStatus(Model model, @PathVariable String status) {
        User currUser = getCurrentUser();
        List<Task> tasks = tasksApi.getTasksByStatusAndDeveloperId(status, currUser.getId());

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
//        log.log(Level.INFO, String.format("urlweb: %s", urlWeb));

        return "tasks.html";
    }

    /**
     * Страница добавления задачи
     * @param model
     * @return
     */
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
        User currUser = getCurrentUser();
        task.setAuthorId(currUser.getId());
        task.setDeveloperId(currUser.getId());
        tasksApi.createTask(task);
        return "redirect:/";
    }

    /**
     * Страница просмотра задачи
     * @param model
     * @param id
     * @return
     */
    @GetMapping("/task/{id}")
    public String getTaskById(Model model, @PathVariable Long id) {
        TaskGetDto task = tasksApi.getTaskById(id);
//        log.log(Level.INFO, String.format("Task: %s", task));
        model.addAttribute("task", task);
        return "task-view.html";
    }

    /**
     * Страница редактирования задачи
     * @param model
     * @param id
     * @return
     */
    @GetMapping("/task-edit/{id}")
    public String editTaskById(Model model, @PathVariable Long id) {
        TaskGetDto task = tasksApi.getTaskById(id);
//        log.log(Level.INFO, String.format("Task: %s", task));
        model.addAttribute("task", task);
        return "task-edit.html";
    }

    @PostMapping("/task-update")
    public String updateTask(Model model, Task task) {
        User currUser = getCurrentUser();
        task.setAuthorId(currUser.getId());
        tasksApi.update(task);
        return "redirect:/task/"+task.getId();
    }

    /**
     * Страница "Личный кабинет"
     * @param model
     * @return
     */
    @GetMapping("/lk")
    public String showUserInfo(Model model) {
        model.addAttribute("user", getCurrentUser());
        String urlWeb = appConfig.getHost()+ ":" + appConfig.getServerPort();
        String refBack = "/";
        model.addAttribute("showBtns", true);
        model.addAttribute("refBack", refBack);
        model.addAttribute("urlWeb", urlWeb);
        return "personal.html";
    }

    /**
     * Просмотр ЛК связанного пользователя
     * @param model
     * @param id
     * @return
     */
    @GetMapping("/lk-user/{id}")
    public String getUserInfo(Model model, @PathVariable Long id) {
        model.addAttribute("user", userApi.findUserById(id));
        String urlWeb = appConfig.getHost()+ ":" + appConfig.getServerPort();
        String refBack = "/list-dev";
        model.addAttribute("showBtns", false);
        model.addAttribute("refBack", refBack);
        model.addAttribute("urlWeb", urlWeb);
        return "personal.html";
    }

    /**
     * Страница "Список связанных пользователей"
     * @param model
     * @return
     */
    @GetMapping("/list-dev")
    public String showDevUserList(Model model) {
        List<UserGetDto> list = userApi.getUserListByDevId(getCurrentUser().getId());
        String urlWeb = appConfig.getHost()+ ":" + appConfig.getServerPort();

        model.addAttribute("list", list);
        return "users-list.html";
    }

    /**
     * Страница создания пользователя
     * @param model
     * @return
     */
    @GetMapping("/create-user")
    public String addUser(Model model) {
        String urlWeb = appConfig.getHost()+ ":" + appConfig.getServerPort() + "/create-user";
        model.addAttribute("urlWeb", urlWeb);
        return "create-user.html";
    }

    /**
     * POST - запрос создания пользователя
     * @param usr
     * @return
     */
    @PostMapping("/create-user")
    public String createUser(UserDto usr) {
        User currUser = getCurrentUser();
        User user = usr.fromDto();
        user.setDevId(currUser.getId());
        user.setStatus(getAllowedStatus(currUser.getStatus()));
        userApi.createUser(user);
        return "redirect:/list-dev";
    }

    /**
     * Удаление пользователя по id
     * @param id
     * @return
     */
    @PostMapping("/delete-user/{id}")
    public String deleteUserById(@PathVariable Long id) {
        userApi.deleteUserById(id);
        return "redirect:/list-dev";
    }

    @GetMapping("/list-mess/{id}")
    public String getAllMessages(Model model, @PathVariable Long id) {
        List<UserMessageDto> list = messApi.getAllMessByTaskId(id);
        User currUser = getCurrentUser();
        model.addAttribute("list", list);
        model.addAttribute("taskId", id);
        model.addAttribute("userId",currUser.getId());
        return "mess-list.html";
    }

    @GetMapping("/create-mess/{taskId}")
    public String newMessage(Model model, @PathVariable Long taskId) {
        String urlWeb = appConfig.getHost()+ ":" + appConfig.getServerPort() + "/create-mess/"+taskId;
        model.addAttribute("urlWeb", urlWeb);
        model.addAttribute("taskId", taskId);
        return "create-mess.html";
    }

    @PostMapping("/create-mess")
    public String createMessage(MessageCreateDto mess) {
        User currUser = getCurrentUser();
        mess.setUserId(currUser.getId());

        return "redirect:/list-dev";
    }









    /**
     * Вспомогательный метод получения текущего пользователя
     * @return
     */
    private User getCurrentUser() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }
        return userApi.getByUsername(username);
    }

    /**
     * Вспомогательный метод получения доступного статуса при создании нового пользователя
     * @param status
     * @return
     */
    private UserStatus getAllowedStatus(UserStatus status) {
        return switch (status) {
            case ADMIN -> UserStatus.DEV;
            case DEV -> UserStatus.AUTHOR;
            default -> null;
        };
    }
}
