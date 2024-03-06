package ru.gromdv.webService.service;

import lombok.AllArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.gromdv.webService.config.AppConfig;
import ru.gromdv.webService.dto.MessageDto;

import java.util.List;

@Service
@AllArgsConstructor
public class MessagesApi {
    private RestTemplate template;
    private HttpHeaders headers;
    private final AppConfig appConfig;

    public List<MessageDto> getAllMess() {
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        String url = appConfig.getHost()+ ":" + appConfig.getGatewayPort() + appConfig.getUrlApiMessages() + "/list";
        ResponseEntity<?> response = template.exchange(url, HttpMethod.GET, entity, List.class);

        return (List<MessageDto>) response.getBody();
    }
}
