package ru.gromdv.addsService.controller;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gromdv.addsService.model.FileInStorage;
import ru.gromdv.addsService.service.FileStorageService;

import java.time.LocalDateTime;
import java.util.List;

@org.springframework.web.bind.annotation.RestController
@AllArgsConstructor
@Log
@RequestMapping("/adds")
public class RestController {

    private final FileStorageService servise;

    /**
     * Получаем список всех файлов
     * @return
     */
    @GetMapping("/list")
    public ResponseEntity<List<FileInStorage>> getUsersList() {
        List<FileInStorage> tasks = servise.getFilesList();
//        log.log(Level.INFO, String.format("LIST: %s", tasks));

        return ResponseEntity.ok().body(tasks);
    }
    /**
     * Получаем список файлов по задаче
     * @return
     */
    @GetMapping("/list-task/{taskId}")
    public ResponseEntity<List<FileInStorage>> getUsersListByStatus(@PathVariable Long taskId) {
        List<FileInStorage> list = servise.getFilesByTaskId(taskId);
//        log.log(Level.INFO, String.format("LIST: %s", list));

        return ResponseEntity.ok().body(list);
    }

    /**
     * Добавляем в базу новый файл
     * @param file
     * @return
     */
    @PostMapping("/create")
    public ResponseEntity<?> createUserForm(@RequestBody FileInStorage file) {
        file = servise.save(file);
        return ResponseEntity.ok().body(file);
    }

    /**
     * Удаляем файл из базы по id
     * @param id
     */
    @DeleteMapping("/delete/{id}")
    public void deleteUserById(@PathVariable Long id) {
        servise.deleteFileById(id);
    }
}
