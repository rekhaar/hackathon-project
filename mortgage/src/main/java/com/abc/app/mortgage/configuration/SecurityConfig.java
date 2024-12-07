package com.abc.app.mortgage.configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable);
        http.authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/*" ,"/swagger-ui/**", "/v3/api-docs/**", "/swagger-ui.html").authenticated()  // Require authentication
                        .anyRequest().permitAll()
                )
                .formLogin(withDefaults())  // Enable form-based login
                .httpBasic(withDefaults()); // Enable basic authentication

        return http.build();
    }
}