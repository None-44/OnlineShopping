package com.example.onlineshop.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CORS implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")  // 允许所有路径
                .allowedOrigins("http://localhost:5173")  // 允许的源
                .allowedMethods("GET", "POST", "PUT", "DELETE")  // 允许的HTTP方法
                .allowedHeaders("*");  // 允许的请求头
    }
}