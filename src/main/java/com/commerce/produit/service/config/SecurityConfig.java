package com.commerce.produit.service.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    private static final String[] WHITE_LIST_URL = { "/auth/login/**", "/api/v1/auth/**", "/v2/api-docs", "/v3/api-docs",
            "/v3/api-docs/**", "/swagger-resources", "/swagger-resources/**", "/configuration/ui",
            "/configuration/security", "/swagger-ui/**", "/webjars/**", "/swagger-ui.html", "/api/auth/**",
            "/api/test/**", "/authenticate", "/api/products/**" };

    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager(){
        PasswordEncoder passwordEncoder= passwordEncoder();
        return new InMemoryUserDetailsManager(
                User.withUsername("user").password(passwordEncoder.encode("password")).authorities("USER").build(),
                User.withUsername("admin").password(passwordEncoder.encode("password")).authorities("USER","ADMIN").build()

        );
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        return httpSecurity
                .csrf(csrf -> csrf.disable())

                .authorizeHttpRequests(ar->ar.requestMatchers(
                        WHITE_LIST_URL).permitAll())
                .authorizeHttpRequests(ar->ar.anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults())
                .build();

    }
}