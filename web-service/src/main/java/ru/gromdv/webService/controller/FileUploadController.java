package ru.gromdv.webService.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.gromdv.webService.config.AppConfig;
import ru.gromdv.webService.model.FileInStorage;
import ru.gromdv.webService.service.FileStorageApi;
import ru.gromdv.webService.service.TasksApiImpl;
import ru.gromdv.webService.service.UserApiImpl;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

@Controller
@AllArgsConstructor
public class FileUploadController {

    private final AppConfig appConfig;
    private final TasksApiImpl tasksApi;
    private final UserApiImpl userApi;
    private final FileStorageApi fileStorageApi;

    @GetMapping("/upload/{taskId}")
    public String provideUploadInfo(Model model, @PathVariable Long taskId) {
        model.addAttribute("taskId", taskId);
        return "file-upload.html";
    }

    @PostMapping("/upload/{taskId}")
    public String handleFileUpload(@RequestParam("file") MultipartFile file,
                                                 @PathVariable Long taskId){
        String name = file.getOriginalFilename();
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                BufferedOutputStream stream =
                        new BufferedOutputStream(new FileOutputStream(new File(appConfig.getPathFileStorage() + name)));
                stream.write(bytes);
                stream.close();
                FileInStorage newFile = new FileInStorage();
                newFile.setFileName(name);
                newFile.setTaskId(taskId);
                fileStorageApi.createFileInStorage(newFile);
                return "redirect:/list-adds/"+taskId;
            } catch (Exception e) {
                return "Не удалось загрузить " + name + " => " + e.getMessage();
            }
        } else {
            return "Не удалось загрузить " + name + " потому что файл пустой.";
        }
    }
}
