package ru.gromdv.messageService.dto;

import org.springframework.stereotype.Component;
import ru.gromdv.messageService.model.Message;

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
}
