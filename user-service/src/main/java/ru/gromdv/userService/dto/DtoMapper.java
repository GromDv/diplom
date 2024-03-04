package ru.gromdv.userService.dto;

import org.springframework.stereotype.Component;
import ru.gromdv.userService.model.User;
import ru.gromdv.userService.model.UserStatus;

import java.time.LocalDateTime;

@Component
public class DtoMapper {

    public static UserDto toDto(User user) {
        UserDto dto = new UserDto();

        dto.setId(user.getId());
        dto.setDevId(user.getDevId());
        dto.setUsername(user.getUsername());
        dto.setPassword(user.getPassword());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setEMail(user.getEMail());
        dto.setStatus(user.getStatus());
        dto.setStatusGood(user.getStatus());
        dto.setDateCreate(user.getDateCreate());
        dto.setDateCreateGood(user.getDateCreate());
        dto.setDateExpired(user.getDateExpired());
        dto.setDateExpiredGood(user.getDateExpired());
        dto.setEnabled(user.isEnabled());

        return dto;
    }
}