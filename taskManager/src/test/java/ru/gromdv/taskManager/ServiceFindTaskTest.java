package ru.gromdv.taskManager;

import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.gromdv.taskManager.dto.*;
import ru.gromdv.taskManager.repository.TaskRepository;
import ru.gromdv.taskManager.service.TaskServise;

import java.util.List;

@SpringBootTest
class ServiceFindTaskTest {
	@Autowired
	private TaskServise servise;
	@Autowired
	private TaskRepository repository;
	@Autowired
	private DtoMapper dtoMapper;

	@ParameterizedTest
	@ValueSource(strings = "Задача 5")
	void contextLoads(String name) {
		List<TaskDto> tasks = servise.getTasksList().stream().map(dtoMapper::toDto).toList();

		assert !tasks.isEmpty();
		assert tasks.get(0).getName().equals(name);
	}

}
