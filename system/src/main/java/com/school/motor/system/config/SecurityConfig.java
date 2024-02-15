package com.school.motor.system.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
@Configuration
@EnableWebSecurity //开启
public class SecurityConfig {
    private final String[] matchers = {"/system/csrf","/system/register","/question/get"};
    @Bean
    public SecurityFilterChain getSecurityFilterChain(
            HttpSecurity http, BCryptPasswordEncoder encoder,
            PersistentTokenRepository repository,
            AuthenticationSuccessHandler success,
            AuthenticationFailureHandler failure,
            LogoutSuccessHandler logout,
            UserDetailsService user) throws Exception {
//        配置登陆
        http.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(user)
                .passwordEncoder(encoder);
//        配置过滤拦截
        http.authorizeHttpRequests(auth -> auth.requestMatchers(matchers)
                .permitAll()
                .anyRequest()
                .authenticated()
        );
        http.rememberMe(auth -> auth
                .tokenRepository(repository)
                .tokenValiditySeconds(60 * 60 * 24 * 7) //记住我默认为7天
        );
        http.formLogin(auth -> auth
                .successHandler(success)
                .failureHandler(failure)
                .loginProcessingUrl("/user/login")
                .permitAll()
        );
        http.logout(auth -> auth.logoutSuccessHandler(logout));
        return http.build();
    }
    @Bean("encoder")
    public BCryptPasswordEncoder getBCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
