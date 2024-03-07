package ru.gromdv.taskManager.service;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import ru.gromdv.taskManager.model.Task;
import ru.gromdv.taskManager.repository.TaskRepository;

import java.util.Collection;
import java.util.List;
import java.util.logging.Level;

@Service
@Log
@AllArgsConstructor
public class TaskService {
    private final TaskRepository repository;


    public List<Task> getTasksList() {
//        log.log(Level.INFO, String.format("TYPE_REPO: %s", repository));
        return repository.findAll();
    }

    public void addNewTask(Task t) {
        repository.save(t);
    }

    public Task getTaskById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void saveTask(Task task) {
        repository.save(task);
    }

    public List<Task> getDeveloperTasksList(Long id) {
        return repository.findAllByDeveloperId(id);
    }
}
