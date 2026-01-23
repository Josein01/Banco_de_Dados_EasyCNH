package com.example.demo.CourseAccess;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/API/CourseAccess")
public class CourseAccessController {
    private final CourseAccessService courseAccessService;
    @Autowired
    public CourseAccessController(CourseAccessService courseAccessService) {
        this.courseAccessService = courseAccessService;
    }
    @GetMapping
    public List<CourseAccess> getCourseAccess() {
        return courseAccessService.getCourseAccess();
    }
}
