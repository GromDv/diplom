package ru.gromdv.webService.config;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.gromdv.webService.service.UserApiImpl;

@Service
@AllArgsConstructor
public class UserSecurityConfig implements UserDetailsService {

    private UserApiImpl userApi;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ru.gromdv.webService.model.User myUser = userApi.getByUsername(username);
        if (myUser == null) {
            throw new UsernameNotFoundException(username);
        }
        return User.withDefaultPasswordEncoder()
                .username(myUser.getUsername())
                .password(myUser.getPassword())
                .roles(myUser.getRole())
                .build();
    }
}
