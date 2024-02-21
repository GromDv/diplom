package ru.gromdv.taskManager.service;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import ru.gromdv.taskManager.model.Task;
import ru.gromdv.taskManager.repository.TaskRepository;
import java.util.List;
import java.util.logging.Level;

@Service
@Log
@AllArgsConstructor
public class TaskServise {
    private final TaskRepository repository;


    public List<Task> getTasksList() {
        log.log(Level.INFO, String.format("TYPE_REPO: %s", repository));
        return repository.findAll();
    }
}
