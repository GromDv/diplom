package ru.gromdv.webService.model;

import lombok.Data;

@Data
public class UserDto {
    private String username;

    private String password;

    private String lastName;

    private String eMail;
}
