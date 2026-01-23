package com.example.demo.Quiz;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuizConfig {
 @Bean
    CommandLineRunner commandLineRunnerQuiz(QuizRepository quizRepository) {
        return args -> {
        };
    }
}