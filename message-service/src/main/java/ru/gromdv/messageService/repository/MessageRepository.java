package ru.gromdv.messageService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.gromdv.messageService.dto.UserMessageDto;
import ru.gromdv.messageService.model.Message;

import java.util.List;


@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {




    List<Message> findAllByTaskId(Long taskId);


    // select * from messages m left join users u on u.id = m.user_id where task_id = 1;
    // SELECT d.name, e.name, e.email, e.address, d.id FROM department d INNER JOIN employee e ON d.id = e.dept_id;
    @Query(value = "select m.id, m.task_id, m.user_id, m.parent_mess_id," +
            " (select count(id) from messages where parent_mess_id  = m.id) as num_mess," +
            " m.title, m.text, m.status, m.date_create, u.username from messages m left join users u on u.id = m.user_id where task_id = ?1", nativeQuery = true)
    List<?> findAllByTaskIdWithUserName(Long taskId);
}
