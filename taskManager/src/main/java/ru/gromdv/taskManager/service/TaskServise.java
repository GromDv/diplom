package ru.gromdv.taskManager.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gromdv.taskManager.model.Task;
import ru.gromdv.taskManager.repository.TaskRepository;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
@AllArgsConstructor
public class TaskServise {
    private final TaskRepository repository;


    public List<Task> getTasksList() {
        return repository.findAll();
    }
}
