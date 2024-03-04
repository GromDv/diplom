package ru.gromdv.webService.dto;

import ru.gromdv.webService.model.UserStatus;

import java.time.LocalDateTime;

public class UserGetDto {
    private Long id;

    private Long devId;

    private String username;

    private String password;

    private String firstName;

    private String lastName;

    private String eMail;

    private UserStatus status;

    private LocalDateTime dateCreate;

    private String dateCreateGood;

    private LocalDateTime dateExpired;

    private String dateExpiredGood;

    private boolean isEnabled;
}
