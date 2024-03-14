package ru.gromdv.addsService;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.gromdv.addsService.model.FileInStorage;
import ru.gromdv.addsService.repository.FilesRepository;
import ru.gromdv.addsService.service.FileStorageService;

import java.util.List;

@SpringBootTest
class ServiceFindTaskTest {
	@Autowired
	private FileStorageService service;
	@Autowired
	private FilesRepository repository;
	@Autowired
	private FileInStorage user;

	@ParameterizedTest
	@ValueSource(strings = "filename")
	void contextLoads(String name) {
		List<FileInStorage> tasks = service.getFilesList();

		assert !tasks.isEmpty();
		assert tasks.get(0).getFileName().equals(name);
	}

}
