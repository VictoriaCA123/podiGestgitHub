package com.podiGest.backend.service;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Configuramos los puertos comunes de desarrollo de Vue/Vite (8081, 5173).
        registry.addMapping("/**") // Aplica la regla a todas las rutas de la API
                .allowedOrigins("http://localhost:8081", "http://localhost:5173", "http://127.0.0.1:8081")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Permite los métodos HTTP comunes
                .allowedHeaders("*")
                .allowCredentials(true);
    }
}
