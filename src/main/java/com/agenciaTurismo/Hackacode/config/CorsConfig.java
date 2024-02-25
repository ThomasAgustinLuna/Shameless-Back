package com.agenciaTurismo.Hackacode.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(@NonNull CorsRegistry registry) {
        registry.addMapping("/greeting-javaconfig").allowedOrigins("http://localhost:5173").allowedMethods("*")
                .allowedHeaders("*").allowCredentials(true);
    }
}
