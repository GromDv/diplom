package ru.gromdv.webService.model;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


@Data
public class User implements UserDetails{

    private Long id;

    private Long devId;

    private String username;

    private String password;

    private String firstName;

    private String lastName;

    private String eMail;

    private UserStatus status;

    private LocalDateTime dateCreate;

    private LocalDateTime dateExpired;

    private boolean isEnabled;

    public String getRole() {
        return switch(status) {
            case ADMIN -> "ADMIN";
            case DEV -> "DEVELOPER";
            case AUTHOR -> "AUTHOR";
            case VIEWER -> "VIEWER";
        };
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
        switch(status) {
            case ADMIN -> authorities.add(new SimpleGrantedAuthority("ADMIN"));
            case DEV -> authorities.add(new SimpleGrantedAuthority("DEVELOPER"));
            case AUTHOR -> authorities.add(new SimpleGrantedAuthority("AUTHOR"));
            case VIEWER -> authorities.add(new SimpleGrantedAuthority("VIEWER"));
        }
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + ", password=" + password + "]";
    }
}
