package ru.gromdv.taskManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gromdv.taskManager.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}
