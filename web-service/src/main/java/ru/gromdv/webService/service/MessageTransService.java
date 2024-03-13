package ru.gromdv.webService.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gromdv.webService.dto.DtoMapper;
import ru.gromdv.webService.dto.ListUMDto;
import ru.gromdv.webService.dto.UserMessDTOWithChildMess;
import ru.gromdv.webService.dto.UserMessageDto;

import java.util.List;
import java.util.stream.Stream;

@Service
@AllArgsConstructor
public class MessageTransService {
    private final MessagesApi messagesApi;

    public List<UserMessDTOWithChildMess> getMessTree(Long taskId) {
        ListUMDto list = messagesApi.getAllMessByTaskId(taskId);

        List<UserMessDTOWithChildMess> tmpList = list.getList()
                .stream()
                .map(DtoMapper::toUserMessDTOWithChildMess)
                .toList();

        for (UserMessDTOWithChildMess mess : tmpList) {
            mess.setListChildMess(tmpList
                    .stream()
                    .filter(x -> x.getParentMessId() != null)
                    .filter(x -> x.getParentMessId().equals(mess.getId()))
//                    .map(DtoMapper::toUserMessDTOWithChildMess)
                    .toList()
            );
        }
        return tmpList.stream()
                .filter(x -> x.getParentMessId() == null)
                .toList();
    }
}
