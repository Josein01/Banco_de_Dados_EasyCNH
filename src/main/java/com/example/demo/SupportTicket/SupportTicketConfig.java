package com.example.demo.SupportTicket;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SupportTicketConfig {
    @Bean
    CommandLineRunner commandLineRunnerSupportTicket(SupportTicketRepository supportTicketRepository) {
        return args -> {
        };
    }
}
