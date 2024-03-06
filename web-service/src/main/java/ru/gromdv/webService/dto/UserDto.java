package ru.gromdv.webService.dto;

import lombok.Data;
import ru.gromdv.webService.model.User;
@Data
public class UserDto {

    private String username;

    private String password;

    private String firstName;

    private String lastName;

    private String eMail;

    public User fromDto() {
        User user = new User();
        user.setUsername(getUsername());
        user.setFirstName(getFirstName());
        user.setLastName(getLastName());
        user.setEMail(getEMail());
        user.setPassword(getPassword());
        return user;
    }
}
