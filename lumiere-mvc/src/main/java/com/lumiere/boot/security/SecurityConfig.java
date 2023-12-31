package com.lumiere.boot.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity

public class SecurityConfig {
	@Autowired
    private UserDetailsService userDetailsService;

    @Bean
    protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests((authorize) ->
                        authorize
                        .requestMatchers("/css/**", "/img/**").permitAll()
                        .requestMatchers("/", "/home").permitAll()
                        .requestMatchers("/Usuario/Cadastrar", "/Usuario/Salvar").permitAll()
                        .requestMatchers("/gastos/**", "/Residencia/**", "/Dispositivo/**").authenticated()
                        .anyRequest().authenticated()
                ).formLogin(
                form -> form
                        .loginPage("/Usuario/Login")
                        .usernameParameter("emailUsuario")
                        .passwordParameter("senhaUsuario")
                        .loginProcessingUrl("/Usuario/Login")
                        .defaultSuccessUrl("/Residencia/Listar")
                        .permitAll()
        ).logout(
                logout -> logout
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                        .permitAll()
        );
        
        return http.build();
    }
    
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
        
    }

    @Bean
    static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
