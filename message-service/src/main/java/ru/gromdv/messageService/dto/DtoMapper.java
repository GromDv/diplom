package ru.gromdv.messageService.dto;

import org.springframework.stereotype.Component;
import ru.gromdv.messageService.model.Message;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Component
public class DtoMapper {

    public MessageDto toDto(Message message) {
        MessageDto messageDto = new MessageDto();
        messageDto.setId(message.getId());
        messageDto.setTaskId(message.getTaskId());
        messageDto.setParentMessId(message.getParentMessId());
        messageDto.setTitle(message.getTitle());
        messageDto.setText(message.getText());
        messageDto.setDateCreate(message.getDateCreate());
        messageDto.setStatus(message.getStatus());
        return messageDto;
    }


    public Message toEntity(MessageDto messageDto) {
        Message message = new Message();
        message.setId(messageDto.getId());
        message.setTaskId(messageDto.getTaskId());
        message.setParentMessId(messageDto.getParentMessId());
        message.setTitle(messageDto.getTitle());
        message.setText(messageDto.getText());
        message.setDateCreate(messageDto.getDateCreate());
        message.setStatus(messageDto.getStatus());
        return message;
    }

    public static UserMessageDto toUserMessageDto(Object[] in) {
        UserMessageDto m = new UserMessageDto();
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
