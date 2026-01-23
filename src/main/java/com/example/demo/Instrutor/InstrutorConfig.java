package com.example.demo.Instrutor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InstrutorConfig {
    @Bean
    CommandLineRunner commandLineRunnerInstrutor(InstrutorRepository instrutorRepository) {
        return args -> {
        };
    }

}
