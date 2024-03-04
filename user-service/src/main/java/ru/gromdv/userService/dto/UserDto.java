package ru.gromdv.userService.dto;

import lombok.Data;
import ru.gromdv.userService.model.UserStatus;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
public class UserDto {

    private Long id;

    private Long devId;

    private String username;

    private String password;

    private String firstName;

    private String lastName;

    private String eMail;

    private UserStatus status;

    private String statusGood;

    private LocalDateTime dateCreate;

    private String dateCreateGood;

    private LocalDateTime dateExpired;

    private String dateExpiredGood;

    private boolean isEnabled;


    public void setStatusGood(UserStatus status) {
        statusGood = switch (status) {
            case ADMIN -> "Администратор";
            case DEV -> "Разработчик";
            case AUTHOR -> "Пользователь";
            case VIEWER -> "Наблюдатель";
            default -> "не определен";
        };
    }
    public String getStatusGood() {
        return switch (status) {
            case ADMIN -> "Администратор";
            case DEV -> "Разработчик";
            case AUTHOR -> "Пользователь";
            case VIEWER -> "Наблюдатель";
            default -> "не определен";
        };
    }
    public String getDateCreateGood() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm dd-MM-yyyy");
        return dateCreate.format(formatter);
    }
    public void setDateCreateGood(LocalDateTime dt) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm dd-MM-yyyy");
        dateCreateGood = dt.format(formatter);
    }
    public String getDateExpiredGood() {
        if(dateExpired != null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            return dateExpired.format(formatter);
        } else {
            return "-";
        }
    }
    public void setDateExpiredGood(LocalDateTime dt) {
        if(dt != null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            dateExpiredGood = dt.format(formatter);
        } else {
            dateExpiredGood = "-";
        }
    }
}
