package com.example.demo.CourseLesson;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CourseLessonConfig {
    @Bean
    CommandLineRunner commandLineRunnerCourseLesson(CourseLessonRepository courseLessonRepository) {
        return args -> {
        };
    }
}
