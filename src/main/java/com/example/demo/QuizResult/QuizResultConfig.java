package com.example.demo.QuizResult;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuizResultConfig {
    @Bean
    CommandLineRunner commandLineRunnerQuizResult(QuizResultRepository quizResultRepository) {
        return args -> {
        };
    }

}
