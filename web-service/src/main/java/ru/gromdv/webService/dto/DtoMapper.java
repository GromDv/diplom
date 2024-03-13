package ru.gromdv.webService.dto;

import org.springframework.stereotype.Component;

import java.sql.Timestamp;

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

    public static UserMessDTOWithChildMess toUserMessDTOWithChildMess(UserMessageDto in) {
        UserMessDTOWithChildMess out = new UserMessDTOWithChildMess();

        out.setId(in.getId());
        out.setTaskId(in.getTaskId());
        out.setUserId(in.getUserId());
        out.setParentMessId(in.getParentMessId());
        out.setNumMess(in.getNumMess());
        out.setTitle(in.getTitle());
        out.setText(in.getText());
        out.setStatus(in.getStatus());
        out.setDateCreate(in.getDateCreate());
        out.setUsername(in.getUsername());
        out.setListChildMess(null);

        return out;
    }

}
