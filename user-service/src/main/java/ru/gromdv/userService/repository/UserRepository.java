package ru.gromdv.userService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gromdv.userService.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findAllByUsername(String username);
}
