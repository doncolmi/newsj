package org.example.springboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class GpConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry cr) {
        cr.addMapping("/**")
                .allowedOrigins("http://localhost:3000");
    }
}
