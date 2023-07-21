package com.example.springboot.webtodolist;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.function.Function;

@Configuration
public class SpringSecurityConfiguration {
    //LDAP or Database
    //In Memory

    @Bean
    public InMemoryUserDetailsManager createUserDetailsManager() {
        UserDetails userDetails1 = createNewUser("joona", "dummy");
        UserDetails userDetails2 = createNewUser("ranga", "dummydummy");

        return new InMemoryUserDetailsManager(userDetails1, userDetails2);
    }

    private UserDetails createNewUser(String userName, String password) {
        Function<String, String> passwordEncoder
                = input -> passwordEncoder().encode(input);

        UserDetails userDetails = User.builder()
                .passwordEncoder(passwordEncoder)
                .username(userName)
                .password(password)
                .roles("USER", "ADMIN")
                .build();
        return userDetails;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        //BCrypt 스트롱 해싱 함수를 사용하고있다.
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // 모든 요청에 대해 승인
        http.authorizeHttpRequests(
                auth -> auth.anyRequest().authenticated());
        // 승인되지 않은 요청이 있다면 formLogin 설정을 통해 사용자 이름과 패스워드를
        //  수집할 수 있는 페이지를 표시할 수 있게 한다.
        http.formLogin(withDefaults());

        // csrf에 대해 비활성화
        http.csrf().disable();
        // 애플리케이션에서 프레임 사용을 비활성화
        http.headers().frameOptions().disable();

        return http.build();
    }

}
