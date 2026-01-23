package com.example.demo.InstructorReview;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InstructorReviewConfig {
        @Bean
        CommandLineRunner commandLineRunnerInstructorReview(InstructorReviewRepository instructorReviewRepository) {
            return args -> {
        };  
}
}