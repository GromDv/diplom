package ru.gromdv.messageService.model;

import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "messages")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "task_id")
    private Long taskId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "parent_mess_id")
    private Long parentMessId;

    private String title;

    private String text;

    @Enumerated(EnumType.STRING)
    private ru.gromdv.messageService.model.MessageStatus status;

    @Column(name = "date_create")
    private LocalDateTime dateCreate;
}
