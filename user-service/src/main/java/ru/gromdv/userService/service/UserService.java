package ru.gromdv.userService.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gromdv.userService.model.User;
import ru.gromdv.userService.repository.UserRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository repository;


    public List<User> getUserList() {
        return repository.findAll();
    }

    public User getUserByUsername(String username) {
        return repository.findAllByUsername(username);
    }
}
