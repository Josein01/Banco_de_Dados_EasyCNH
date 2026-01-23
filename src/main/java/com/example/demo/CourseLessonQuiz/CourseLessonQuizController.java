package com.example.demo.CourseLessonQuiz;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/API/CourseLessonQuiz")
public class CourseLessonQuizController {
    private final CourseLessonQuizService courseLessonQuizService;
    @Autowired
    public CourseLessonQuizController(CourseLessonQuizService courseLessonQuizService) {
        this.courseLessonQuizService = courseLessonQuizService;
    }
    @GetMapping
    public List<CourseLessonQuiz> getCourseLessonQuizzes() {
        return courseLessonQuizService.getCourseLessonQuizzes();
    }
}