package ru.gromdv.userService.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dev_id")
    private Long devId;

    private String username;

    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "e_mail")
    private String eMail;

    @Enumerated(EnumType.STRING)
    private UserStatus status;

    @Column(name = "date_create")
    private LocalDateTime dateCreate;

    @Column(name = "date_expired")
    private LocalDateTime dateExpired;

    @Column(name = "is_enabled")
    private boolean isEnabled;
}
