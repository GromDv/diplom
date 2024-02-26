package ru.gromdv.webService.dto;

import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.core.serializer.Deserializer;
import ru.gromdv.webService.model.Task;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.List;

@Data

public class ListDto {
    List<TaskDto> tasksList;
}
