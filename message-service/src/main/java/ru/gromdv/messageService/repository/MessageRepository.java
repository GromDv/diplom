package ru.gromdv.messageService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gromdv.messageService.model.Message;


@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
}
