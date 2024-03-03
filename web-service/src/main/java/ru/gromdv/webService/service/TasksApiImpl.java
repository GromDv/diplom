package ru.gromdv.webService.service;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.*;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.gromdv.webService.config.AppConfig;
import ru.gromdv.webService.dto.ListDto;
import ru.gromdv.webService.dto.TaskDto;
import ru.gromdv.webService.dto.TaskGetDto;
import ru.gromdv.webService.model.Task;
import ru.gromdv.webService.model.TaskStatus;
import ru.gromdv.webService.model.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.stream.Stream;

@Service
@Log
@AllArgsConstructor
public class TasksApiImpl {
    private RestTemplate template;
    private HttpHeaders headers;
    private final AppConfig appConfig;

    public List<Task> getAllTasks() {
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        String url = appConfig.getHost()+ ":" + appConfig.getGatewayPort() + appConfig.getUrlApiTasks() + "/api/list";
        ResponseEntity<?> response = template.exchange(url, HttpMethod.GET, entity, List.class);

        return (List<Task>) response.getBody();
    }

    public void createTask(TaskDto task) {
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        String url = appConfig.getHost()+ ":" + appConfig.getGatewayPort() + appConfig.getUrlApiTasks() + "/api/add";
        ResponseEntity<?> response = template.postForEntity(url, task, TaskDto.class);
        log.log(Level.INFO, String.format("response: %s", response));
    }

    public List<Task> getTasksByStatus(String st) {
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        String url = appConfig.getHost()+ ":" + appConfig.getGatewayPort() + appConfig.getUrlApiTasks() + "/api/list/status/" + st;
        ResponseEntity<?> response = template.exchange(url, HttpMethod.GET, entity, List.class);
        return (List<Task>) response.getBody();
    }

    /**
     * Получить задачу по её id
     * @param id
     * @return
     */
    public TaskGetDto getTaskById(Long id) {
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        String url = appConfig.getHost()+ ":" + appConfig.getGatewayPort() + appConfig.getUrlApiTasks() + "/api/task/" + id;
        ResponseEntity<?> response = template.exchange(url, HttpMethod.GET, entity, TaskGetDto.class);
        return (TaskGetDto) response.getBody();
    }


}
