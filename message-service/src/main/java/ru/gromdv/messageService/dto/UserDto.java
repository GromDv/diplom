package ru.gromdv.messageService.dto;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.time.LocalDateTime;

public class UserDto {
    private Long id;
    private Long devId;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String eMail;
    private String status;
    private LocalDateTime dateCreate;
    private LocalDateTime dateExpired;
    private boolean isEnabled;
}
