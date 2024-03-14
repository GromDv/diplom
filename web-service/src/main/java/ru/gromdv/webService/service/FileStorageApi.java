package ru.gromdv.webService.service;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.gromdv.webService.config.AppConfig;
import ru.gromdv.webService.dto.ListFilesInStorage;
import ru.gromdv.webService.dto.ListUMDto;
import ru.gromdv.webService.dto.MessageCreateDto;
import ru.gromdv.webService.dto.MessageDto;
import ru.gromdv.webService.model.FileInStorage;

import java.util.List;
import java.util.logging.Level;

@Service
@Log
@AllArgsConstructor
public class FileStorageApi {
        private RestTemplate template;
        private HttpHeaders headers;
        private final AppConfig appConfig;

        public List<FileInStorage> getListFiles() {
            headers.setAccept(List.of(MediaType.APPLICATION_JSON));
            HttpEntity<String> entity = new HttpEntity<>(headers);
            String url = appConfig.getHost()+ ":" + appConfig.getGatewayPort() + appConfig.getUrlApiAdds() + "/list";
            ResponseEntity<?> response = template.exchange(url, HttpMethod.GET, entity, List.class);

            return (List<FileInStorage>) response.getBody();
        }

        public List<FileInStorage> getListFilesByTask(Long taskId) {
            headers.setAccept(List.of(MediaType.APPLICATION_JSON));
            HttpEntity<String> entity = new HttpEntity<>(headers);
            String url = appConfig.getHost()+ ":" + appConfig.getGatewayPort() + appConfig.getUrlApiAdds() + "/list-task/" + taskId;
            ResponseEntity<?> response = template.exchange(url, HttpMethod.GET, entity, List.class);

            return (List<FileInStorage>) response.getBody();
        }

        public void createFileInStorage(FileInStorage file) {
            headers.setAccept(List.of(MediaType.APPLICATION_JSON));
            HttpEntity<String> entity = new HttpEntity<>(headers);
            String url = appConfig.getHost()+ ":" + appConfig.getGatewayPort()
                    + appConfig.getUrlApiAdds() + "/create";
            ResponseEntity<FileInStorage> response = template.postForEntity(url, file, FileInStorage.class);
//            log.log(Level.INFO, String.format("File record created: %s", response.getBody()));
        }
}
