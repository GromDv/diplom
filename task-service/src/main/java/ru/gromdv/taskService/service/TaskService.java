package ru.gromdv.taskService.service;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import ru.gromdv.taskService.model.Task;
import ru.gromdv.taskService.repository.TaskRepository;

import java.util.List;

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
