package ru.gromdv.webService.service;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.gromdv.webService.config.AppConfig;
import ru.gromdv.webService.dto.UserGetDto;
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

    public void createUser(User user) {
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        String url = appConfig.getHost()+ ":" + appConfig.getGatewayPort()
                + appConfig.getUrlApiUsers() + "/create";
        ResponseEntity<?> response = template.postForEntity(url, user, User.class);
        log.log(Level.INFO, String.format("User create: %s", (User) response.getBody()));
    }

    public List<User> getUserList() {
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        String url = appConfig.getHost()+ ":" + appConfig.getGatewayPort() + appConfig.getUrlApiUsers() + "/list";
        ResponseEntity<?> response = template.exchange(url, HttpMethod.GET, entity, List.class);

//        log.log(Level.INFO, String.format("Users: %s", (List<User>) response.getBody()));
        return (List<User>) response.getBody();
    }

    public User getByUsername(String username) {
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        String url = appConfig.getHost()+ ":" + appConfig.getGatewayPort()
                + appConfig.getUrlApiUsers() + "/user/"+ username;
        ResponseEntity<?> response = template.exchange(url, HttpMethod.GET, entity, User.class);

//        log.log(Level.INFO, String.format("Users: %s", (User) response.getBody()));
        return (User) response.getBody();
    }

    public List<UserGetDto> getUserListByDevId(Long devId) {
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        String url = appConfig.getHost()+ ":" + appConfig.getGatewayPort() + appConfig.getUrlApiUsers() + "/list-dev/" + devId;
        ResponseEntity<?> response = template.exchange(url, HttpMethod.GET, entity, List.class);

        log.log(Level.INFO, String.format("Users: %s", (List<UserGetDto>) response.getBody()));
        return (List<UserGetDto>) response.getBody();
    }

    public void deleteUserById(Long id) {
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        String url = appConfig.getHost()+ ":" + appConfig.getGatewayPort() + appConfig.getUrlApiUsers() + "/delete/" + id;
        template.delete(url);
    }

    public User findUserById(Long id) {
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        String url = appConfig.getHost()+ ":" + appConfig.getGatewayPort()
                + appConfig.getUrlApiUsers() + "/user-id/"+ id;
        ResponseEntity<?> response = template.exchange(url, HttpMethod.GET, entity, User.class);

//        log.log(Level.INFO, String.format("Users: %s", (User) response.getBody()));
        return (User) response.getBody();
    }
}
