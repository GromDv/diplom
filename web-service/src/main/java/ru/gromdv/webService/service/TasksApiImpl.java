package ru.gromdv.webService.service;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.gromdv.webService.config.AppConfig;
import ru.gromdv.webService.dto.TaskDto;
import ru.gromdv.webService.dto.TaskGetDto;
import ru.gromdv.webService.dto.TaskUpdateDto;
import ru.gromdv.webService.model.Task;

import java.util.List;
import java.util.logging.Level;

@Service
@Log
@AllArgsConstructor
public class TasksApiImpl {
    private RestTemplate template;
    private HttpHeaders headers;
    private final AppConfig appConfig;
//    private ModelMapper modelMapper;

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
        ResponseEntity<?> response = template.exchange(url, HttpMethod.GET, entity, Task.class);

        Task task = (Task) response.getBody();
        TaskGetDto dto = null;
        if(task != null)
            dto = new TaskGetDto(task);

        return dto;
    }


    public void update(Task task) {
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        String url = appConfig.getHost()+ ":" + appConfig.getGatewayPort() + appConfig.getUrlApiTasks() + "/api/update";
        template.put(url, new TaskUpdateDto(task), TaskUpdateDto.class);
    }

//    private TaskGetDto convertToTaskGetDto(Task task) {
//        return modelMapper.map(task, TaskGetDto.class);
//    }
}
