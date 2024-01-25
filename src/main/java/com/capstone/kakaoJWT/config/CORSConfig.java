package com.capstone.kakaoJWT.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CORSConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {

            @Override
            public void addCorsMappings(CorsRegistry corsRegistry) {

                //for develop
                corsRegistry
                        .addMapping("/**")
                        .allowedOrigins("https://kauth.kakao.com/oauth/authorize/*", "http://localhost:3000",
                                        "http://localhost:8080/*")
                        .allowedMethods("GET", "POST", "PATCH", "DELETE", "OPTION");
            }
        };
    }
}
