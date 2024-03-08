package ru.gromdv.taskService;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.gromdv.taskService.dto.DtoMapper;
import ru.gromdv.taskService.dto.TaskDto;
import ru.gromdv.taskService.repository.TaskRepository;
import ru.gromdv.taskService.service.TaskService;

import java.util.List;

@SpringBootTest
class ServiceFindTaskTest {
	@Autowired
	private TaskService servise;
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
