package com.example.demo.Aula;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AulaConfig {
    @Bean
    CommandLineRunner commandLineRunnerAula(AulaRepository aulaRepository) {
        return args -> {
        };
    }
}