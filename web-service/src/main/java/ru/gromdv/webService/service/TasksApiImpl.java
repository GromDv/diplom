package ru.gromdv.webService.service;

import lombok.AllArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.gromdv.webService.config.AppConfig;
import ru.gromdv.webService.dto.ListDto;
import ru.gromdv.webService.dto.TaskDto;
import ru.gromdv.webService.model.Task;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

@Service
@AllArgsConstructor
public class TasksApiImpl {
    private RestTemplate template;
    private HttpHeaders headers;
    private final AppConfig appConfig;



    public List<Task> getAllTasks() {
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        String url = appConfig.getUrlApiTasks()+"/api/list";
        ResponseEntity<?> response = template.exchange(url, HttpMethod.GET, entity, List.class);

        //    ResponseEntity<ListDto> response = template.getForEntity(url, ListDto.class );

        return (List<Task>) response.getBody();
    }
}
