package ru.gromdv.userService.controller;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.gromdv.userService.model.User;
import ru.gromdv.userService.service.UserService;

import java.util.List;
import java.util.logging.Level;

@org.springframework.web.bind.annotation.RestController
@AllArgsConstructor
@Log
@RequestMapping("/users")
public class RestController {

    private final UserService servise;

    /**
     * Получаем список пользователей
     * @return
     */
    @GetMapping("/list")
    public ResponseEntity<List<User>> getTasksList() {
        List<User> tasks = servise.getUserList();
        log.log(Level.INFO, String.format("LIST: %s", tasks));

        return ResponseEntity.ok().body(tasks);
    }

    /**
     * Ищем пользователя по имени
     * @return
     */
    @GetMapping("/user/{username}")
    public ResponseEntity<User> getUserByUserame(@PathVariable String username) {
        User user = servise.getUserByUsername(username);
        log.log(Level.INFO, String.format("USER: %s", user));

        return ResponseEntity.ok().body(user);
    }
}
