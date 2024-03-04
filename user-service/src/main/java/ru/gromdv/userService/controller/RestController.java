package ru.gromdv.userService.controller;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gromdv.userService.dto.DtoMapper;
import ru.gromdv.userService.dto.UserDto;
import ru.gromdv.userService.model.User;
import ru.gromdv.userService.model.UserStatus;
import ru.gromdv.userService.service.UserService;

import java.time.LocalDateTime;
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
    public ResponseEntity<List<User>> getUsersList() {
        List<User> tasks = servise.getUserList();
        log.log(Level.INFO, String.format("LIST: %s", tasks));

        return ResponseEntity.ok().body(tasks);
    }
    /**
     * Получаем список пользователей по профилю
     * @return
     */
    @GetMapping("/list-status/{status}")
    public ResponseEntity<List<User>> getUsersListByStatus(@PathVariable UserStatus status) {
        List<User> list = servise.getUserListByStatus(status);
        log.log(Level.INFO, String.format("LIST: %s", list));

        return ResponseEntity.ok().body(list);
    }
    /**
     * Получаем список пользователей по девелоперу
     * @return
     */
    @GetMapping("/list-dev/{devId}")
    public ResponseEntity<List<UserDto>> getUsersListByDevId(@PathVariable Long devId) {
        List<UserDto> list = servise.getUserListByDevId(devId).stream().map(DtoMapper::toDto).toList();
        log.log(Level.INFO, String.format("LIST: %s", list));

        return ResponseEntity.ok().body(list);
    }

    /**
     * Ищем пользователя по имени
     * @return
     */
    @GetMapping("/user/{username}")
    public ResponseEntity<User> getUserByUserame(@PathVariable String username) {
        User user = servise.getUserByUsername(username);
//        log.log(Level.INFO, String.format("USER: %s", user));

        return ResponseEntity.ok().body(user);
    }

    @GetMapping("/user-id/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = servise.getUserById(id).orElse(null);
//        log.log(Level.INFO, String.format("USER: %s", user));

        return ResponseEntity.ok().body(user);
    }

    /**
     * Создаём нового пользователя
     * @param user
     * @return
     */
    @PostMapping("/create")
    public ResponseEntity<?> createUserForm(@RequestBody User user) {
        user.setDateCreate(LocalDateTime.now());
        user = servise.save(user);
        return ResponseEntity.ok().body(user);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUserById(@PathVariable Long id) {
        servise.deleteUserById(id);
    }
}
