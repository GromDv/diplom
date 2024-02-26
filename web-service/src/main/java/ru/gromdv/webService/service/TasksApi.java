package ru.gromdv.webService.service;

import ru.gromdv.webService.model.Task;

import java.util.List;

public interface TasksApi {
    public List<Task> getAllTasks();
}
