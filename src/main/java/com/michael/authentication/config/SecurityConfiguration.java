package com.michael.authentication.config;

import com.michael.authentication.model.UserRole;
import com.michael.authentication.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import java.util.concurrent.TimeUnit;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public SecurityConfiguration(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{

        httpSecurity
                .csrf().disable()
                .headers( headers -> headers
                        .frameOptions()
                        .disable())
                .authorizeHttpRequests(requests -> requests
                        .requestMatchers("/login", "/logout").permitAll())
//                        .anyRequest()
//                        .authenticated())
                .formLogin( form -> form
                        .loginPage("/login")
                        .loginProcessingUrl("/login")
                        .defaultSuccessUrl("/")
                        .failureUrl("/login?error=true"))
                .rememberMe(rememberMe -> rememberMe
                        .tokenValiditySeconds((int) TimeUnit.DAYS.toSeconds(21))
                        .key("1234552222"));
//                .logout(logout -> logout
//                        .logoutUrl("/logout")
//                        .clearAuthentication(true)
//                        .invalidateHttpSession(true)
//                        .deleteCookies("JSESSIONID", "remember-me")
//                        .logoutUrl("/login"));

       return httpSecurity.build();
    }

}
