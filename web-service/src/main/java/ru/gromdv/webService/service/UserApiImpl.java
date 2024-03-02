package ru.gromdv.webService.service;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.gromdv.webService.config.AppConfig;
import ru.gromdv.webService.model.User;

import java.util.List;
import java.util.logging.Level;

@Service
@Log
@AllArgsConstructor
public class UserApiImpl {
    private RestTemplate template;
    private HttpHeaders headers;
    private final AppConfig appConfig;
    public UserApi getUserList() {
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        String url = appConfig.getHost()+ ":" + appConfig.getGatewayPort() + appConfig.getUrlApiUsers() + "/list";
        ResponseEntity<?> response = template.exchange(url, HttpMethod.GET, entity, UserApi.class);

        log.log(Level.INFO, String.format("Users: %s", (UserApi) response.getBody()));
        return (UserApi) response.getBody();
    }

    public User getByUsername(String username) {
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        String url = appConfig.getHost()+ ":" + appConfig.getGatewayPort()
                + appConfig.getUrlApiUsers() + "/user/"+ username;
        ResponseEntity<?> response = template.exchange(url, HttpMethod.GET, entity, User.class);

        log.log(Level.INFO, String.format("Users: %s", (User) response.getBody()));
        return (User) response.getBody();
    }
}
