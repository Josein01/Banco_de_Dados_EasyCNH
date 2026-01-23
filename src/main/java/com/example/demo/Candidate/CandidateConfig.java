package com.example.demo.Candidate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CandidateConfig {
    @Bean
    CommandLineRunner commandLineRunnerCandidate(CandidateRepository candidateRepository) {
        return args -> {
        };
    }
}
