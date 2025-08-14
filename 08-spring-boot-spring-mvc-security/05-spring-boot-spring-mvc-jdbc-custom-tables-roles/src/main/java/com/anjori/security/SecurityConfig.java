package com.anjori.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    // Add support for JDBC
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        JdbcUserDetailsManager userDetailsManager  = new JdbcUserDetailsManager(dataSource);
    
        // define a query to load user by username
        userDetailsManager.setUsersByUsernameQuery("SELECT user_id, pw, active from members where user_id=?");
    

        // define a query to load user authorities by username
        userDetailsManager.setAuthoritiesByUsernameQuery("SELECT user_id, role from roles where user_id=?");
    
        return userDetailsManager;
    }
    

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(configurer -> 
            configurer
            .requestMatchers("/leaders/**").hasRole("MANAGER")
            .requestMatchers("/systems/**").hasRole("ADMIN")
            .anyRequest().authenticated())
            .formLogin(form -> form.loginPage("/showMyLoginPage")
            .loginProcessingUrl("/authenticateTheUser")
            .permitAll())
            .logout(logout -> logout.permitAll()
            )
            .exceptionHandling(config -> config
                .accessDeniedPage("/access-denied"));

        return http.build();
    }
}
