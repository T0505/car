package com.school.motor.system.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {
    @Bean
    public CorsFilter corsFilter(){

        // 初始化cors配置对象
        CorsConfiguration cors = new CorsConfiguration();
        cors.addAllowedOrigin("*" /*http://172.16.99.181:9528*/);
        cors.setAllowCredentials(true);
        cors.addAllowedMethod("*");
        cors.addAllowedHeader("*");
        // 初始化cors配置源对象
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", cors);

        // 返回配置好的过滤器
        return new CorsFilter(source);
    }
}
