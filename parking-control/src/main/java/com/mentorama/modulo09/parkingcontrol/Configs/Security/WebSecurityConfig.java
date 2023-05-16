package com.mentorama.modulo09.parkingcontrol.Configs.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class WebSecurityConfig {


    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception{
        http
                .httpBasic().and()
                .authorizeHttpRequests()
                .anyRequest().authenticated()
                .and().csrf().disable();
        return http.build();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsService(){
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("jh")
                .password("102030")
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user);
    }
}



