package com.example.demo.CourseAccess;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CourseAccessConfig {
    @Bean
    CommandLineRunner commandLineRunnerCourseAccess(CourseAccessRepository courseAccessRepository) {
        return args -> {
        };
    }
}
