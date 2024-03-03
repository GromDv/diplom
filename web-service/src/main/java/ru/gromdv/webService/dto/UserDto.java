package ru.gromdv.webService.dto;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class UserDto {

    private String username;

    private String password;

    private String lastName;

    private String eMail;
}
