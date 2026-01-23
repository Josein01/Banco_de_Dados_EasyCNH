package com.example.demo.CourseLessonQuiz;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CourseLessonQuizService {
    private final CourseLessonQuizRepository courseLessonQuizRepository;
    public CourseLessonQuizService(CourseLessonQuizRepository courseLessonQuizRepository) {
        this.courseLessonQuizRepository = courseLessonQuizRepository;
    }
    public List<CourseLessonQuiz> getCourseLessonQuizzes() {
        return courseLessonQuizRepository.findAll();
    }

}
