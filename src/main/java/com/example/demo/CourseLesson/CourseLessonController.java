package com.example.demo.CourseLesson;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/API/CourseLesson")
public class CourseLessonController {
        private final CourseLessonService courseLessonService;
        @Autowired
        public CourseLessonController(CourseLessonService courseLessonService) {
            this.courseLessonService = courseLessonService;
        }
        @GetMapping
        public List<CourseLesson> getCourseLessons() {
            return courseLessonService.getCourseLessons();
        }
}
