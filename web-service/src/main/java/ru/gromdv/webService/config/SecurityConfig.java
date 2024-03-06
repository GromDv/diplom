package ru.gromdv.webService.config;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import ru.gromdv.webService.service.UserApiImpl;

@Configuration
@Log
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig {
    private final UserApiImpl userApi;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/login").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin((form) -> form
                        .loginPage("/login")
                        .permitAll()
                )
                .logout((logout) -> logout.permitAll());

        return http.build();
    }



//    @Bean
//    public UserDetailsService userDetailsService() {
//
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//        manager.createUser(User.withDefaultPasswordEncoder()
//                .username("user")
//                .password("user")
//                .roles("USER")
//                .build());
//        manager.createUser(User.withDefaultPasswordEncoder()
//                .username("admin")
//                .password("admin")
//                .roles("ADMIN")
//                .build());
//        manager.createUser(User.withDefaultPasswordEncoder()
//                .username("dev")
//                .password("dev")
//                .roles("DEV")
//                .build());
//        manager.createUser(User.withDefaultPasswordEncoder()
//                .username("author")
//                .password("author")
//                .roles("AUTHOR")
//                .build());
//        return manager;
//    }
}
