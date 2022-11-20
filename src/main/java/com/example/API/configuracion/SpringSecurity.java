package com.example.API.configuracion;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class SpringSecurity {

    @Value("${userLog}")
    private String userLogin;

    @Value("${passLog}")
    private String passLogin;

    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
        UserDetails userDetails = User.withDefaultPasswordEncoder()
                .username(userLogin)
                .password(passLogin)
                .roles("ADMIN").build();
        return new InMemoryUserDetailsManager(userDetails);
    }

    @Bean
    public SecurityFilterChain configure(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/principal/**")
                .authenticated()
                .and()
                .httpBasic(Customizer.withDefaults()).build();
    }
}
