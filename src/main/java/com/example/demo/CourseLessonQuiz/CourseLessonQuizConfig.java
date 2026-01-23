package com.example.demo.CourseLessonQuiz;
import org.springframework.boot.CommandLineRunner;  
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CourseLessonQuizConfig {
    @Bean
    CommandLineRunner commandLineRunnerCourseLessonQuiz(CourseLessonQuizRepository courseLessonQuizRepository) {
        return args -> {
        };
    }
}
