package ru.gromdv.messageService;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.gromdv.messageService.dto.DtoMapper;
import ru.gromdv.messageService.dto.MessageDto;
import ru.gromdv.messageService.repository.MessageRepository;
import ru.gromdv.messageService.service.MessageService;

import java.util.List;

@SpringBootTest
class ServiceFindTaskTest {
	@Autowired
	private MessageService servise;
	@Autowired
	private MessageRepository repository;
	@Autowired
	private DtoMapper dtoMapper;

	@ParameterizedTest
	@ValueSource(strings = "Задача 5")
	void contextLoads(String name) {
		List<MessageDto> tasks = servise.getMessList().stream().map(dtoMapper::toDto).toList();

		assert !tasks.isEmpty();
		assert tasks.get(0).getTitle().equals(name);
	}

}
