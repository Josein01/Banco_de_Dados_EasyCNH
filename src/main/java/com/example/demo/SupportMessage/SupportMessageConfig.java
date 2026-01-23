package com.example.demo.SupportMessage;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SupportMessageConfig {
    @Bean
    CommandLineRunner commandLineRunnerSupportMessage(SupportMessageRepository supportMessageRepository) {
        return args -> {
            // Initial data setup can be added here if needed
        };
    }

}
