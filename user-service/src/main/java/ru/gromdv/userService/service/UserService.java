package ru.gromdv.userService.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gromdv.userService.model.User;
import ru.gromdv.userService.model.UserStatus;
import ru.gromdv.userService.repository.UserRepository;

import java.util.List;
import java.util.Optional;

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

    public User save(User user) {
        repository.save(user);
        return user;
    }

    public List<User> getUserListByStatus(UserStatus status) {
        return repository.findAllByStatus(status);
    }

    public List<User> getUserListByDevId(Long devId) {
        return repository.findAllByDevId(devId);
    }

    public void deleteUserById(Long id) {
        repository.deleteById(id);
    }

    public Optional<User> getUserById(Long id) {
        return repository.findById(id);
    }
}
