package ru.gromdv.userService;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.gromdv.userService.model.User;
import ru.gromdv.userService.repository.UserRepository;
import ru.gromdv.userService.service.UserService;

import java.util.List;

@SpringBootTest
class ServiceFindTaskTest {
	@Autowired
	private UserService service;
	@Autowired
	private UserRepository repository;
	@Autowired
	private User user;

	@ParameterizedTest
	@ValueSource(strings = "user")
	void contextLoads(String name) {
		List<User> tasks = service.getUserList();

		assert !tasks.isEmpty();
		assert tasks.get(0).getUsername().equals(name);
	}

}
