package ru.gromdv.addsService.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "files_tasks")
public class FileInStorage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "filename")
    private String fileName;

    @Column(name = "task_id")
    private Long taskId;
}
