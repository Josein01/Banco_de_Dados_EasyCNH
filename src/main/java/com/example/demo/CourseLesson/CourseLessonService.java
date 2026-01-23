package com.example.demo.CourseLesson;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CourseLessonService {
    private final CourseLessonRepository courseLessonRepository;
    public CourseLessonService(CourseLessonRepository courseLessonRepository) {
        this.courseLessonRepository = courseLessonRepository;
    }
    public List<CourseLesson> getCourseLessons() {
        return courseLessonRepository.findAll();
    }

}
