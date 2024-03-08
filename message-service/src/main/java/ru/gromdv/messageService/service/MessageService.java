package ru.gromdv.messageService.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gromdv.messageService.dto.UserMessageDto;
import ru.gromdv.messageService.repository.MessageRepository;
import ru.gromdv.messageService.model.Message;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class MessageService {
    private final MessageRepository repository;


    public List<Message> getMessList() {
        return repository.findAll();
    }

    public List<Message> getListByTaskId(Long taskId) {
        return repository.findAllByTaskId(taskId);
    }

    public List<?> getListByTaskIdWithUsers(Long taskId) {
        return repository.findAllByTaskIdWithUserName(taskId);
    }

    public void createMessage(Message message) {
        repository.save(message);
    }
}
