package ru.gromdv.webService.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "api")
public class AppConfig {
    private String host;
    private String serverPort;
    private String gatewayPort;
    private String urlApiTasks;
    private String urlApiMessages;
    private String urlApiUsers;
    private String urlApiAdds;
    private String pathFileStorage;
}
