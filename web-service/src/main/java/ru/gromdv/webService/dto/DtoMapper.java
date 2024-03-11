package ru.gromdv.webService.dto;

import org.springframework.stereotype.Component;
import ru.gromdv.messageService.dto.UserMessageDto;

import java.sql.Timestamp;
import java.util.LinkedHashMap;

@Component
public class DtoMapper {

    public static ru.gromdv.webService.dto.UserMessageDto toUserMessageDto(Object[] in) {
        ru.gromdv.webService.dto.UserMessageDto m = new ru.gromdv.webService.dto.UserMessageDto();
        m.setId(Long.valueOf((Integer)in[0]));
        m.setTaskId(Long.valueOf((Integer)in[1]));
        m.setUserId(Long.valueOf((Integer)in[2]));
        if(in[3] != null)
            m.setParentMessId(Long.valueOf((Integer)in[3]));
        m.setTitle( (String) in[4]);
        m.setText( (String) in[5]);
        m.setStatus( (String) in[6]);
        java.sql.Timestamp sqlTimestamp = (Timestamp) in[7];
        m.setDateCreate(sqlTimestamp.toLocalDateTime());
        m.setUsername( (String) in[8]);
        return m;
    }

}
