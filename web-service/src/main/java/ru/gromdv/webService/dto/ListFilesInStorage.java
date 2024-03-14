package ru.gromdv.webService.dto;

import lombok.Data;
import ru.gromdv.webService.model.FileInStorage;

import java.util.List;

@Data
public class ListFilesInStorage {
    List<FileInStorage> list;
}
