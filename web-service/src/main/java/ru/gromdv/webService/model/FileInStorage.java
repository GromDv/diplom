package ru.gromdv.webService.model;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class FileInStorage {
    private Long id;

    private String fileName;

    private Long taskId;
}
