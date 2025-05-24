/*package com.caplorik.smartexpensetracker.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .cors() // Enable CORS
                .and()
                .csrf(csrf -> csrf.disable()) // ❗ Disable CSRF (okay for development)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(
                                "/api/auth/register",
                                "/api/auth/login"
                        ).permitAll() // Allow these without authentication
                        .requestMatchers("/api/expenses/**").authenticated() // Only allow access to /api/expenses for authenticated users
                        .anyRequest().permitAll() // Allow all other requests
                )
                .formLogin()
                .loginPage("/login").permitAll() // Optional, if you want a custom login page
                .and()
                .build(); // Finish the config
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
*/