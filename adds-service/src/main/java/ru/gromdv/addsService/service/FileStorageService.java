package ru.gromdv.addsService.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gromdv.addsService.model.FileInStorage;
import ru.gromdv.addsService.repository.FilesRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FileStorageService {
    private final FilesRepository repository;


    public List<FileInStorage> getFilesList() {
        return repository.findAll();
    }

    public List<FileInStorage> getFilesByTaskId(Long taskId) {
        return repository.findAllByTaskId(taskId);
    }

    public FileInStorage save(FileInStorage file) {
        repository.save(file);
        return file;
    }
    public void deleteFileById(Long id) {
        repository.deleteById(id);
    }

    public Optional<FileInStorage> getFileById(Long id) {
        return repository.findById(id);
    }
}
