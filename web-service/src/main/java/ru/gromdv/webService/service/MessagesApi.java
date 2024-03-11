package ru.gromdv.webService.service;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.gromdv.webService.config.AppConfig;
import ru.gromdv.webService.dto.ListUMDto;
import ru.gromdv.webService.dto.MessageCreateDto;
import ru.gromdv.webService.dto.MessageDto;
import ru.gromdv.webService.dto.UserMessageDto;
import ru.gromdv.webService.model.User;

import java.util.List;
import java.util.logging.Level;

@Service
@Log
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

    public ListUMDto getAllMessByTaskId(Long id) {
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<ListUMDto> entity = new HttpEntity<>(headers);
        String url = appConfig.getHost()+ ":" + appConfig.getGatewayPort() + appConfig.getUrlApiMessages() + "/list-u/"+id;
        ResponseEntity<?> response = template.exchange(url, HttpMethod.GET, entity, ListUMDto.class);

        return (ListUMDto) response.getBody();
    }

    public void createMessage(MessageCreateDto mess) {
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        String url = appConfig.getHost()+ ":" + appConfig.getGatewayPort()
                + appConfig.getUrlApiMessages() + "/create";
        ResponseEntity<?> response = template.postForEntity(url, mess, MessageCreateDto.class);
        log.log(Level.INFO, String.format("Message created: %s", (MessageCreateDto) response.getBody()));
    }

    public UserMessageDto getMessById(Long messId) {
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<UserMessageDto> entity = new HttpEntity<>(headers);
        String url = appConfig.getHost()+ ":" + appConfig.getGatewayPort() + appConfig.getUrlApiMessages() + "/message/"+messId;
        ResponseEntity<?> response = template.exchange(url, HttpMethod.GET, entity, UserMessageDto.class);

        return (UserMessageDto) response.getBody();
    }
}
