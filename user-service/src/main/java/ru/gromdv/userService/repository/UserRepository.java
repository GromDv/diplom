package ru.gromdv.userService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gromdv.userService.model.User;
import ru.gromdv.userService.model.UserStatus;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findAllByUsername(String username);

    List<User> findAllByStatus(UserStatus status);

    List<User> findAllByDevId(Long devId);
}
