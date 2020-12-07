package com.example.config;

import com.example.aspect.StudentLogger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfig {

    @Bean
    public StudentLogger createLogger() {
        return new StudentLogger();
    }

}
