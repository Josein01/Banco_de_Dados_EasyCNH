package com.example.demo.CourseAccess;
import java.util.List;

import org.springframework.stereotype.Service;

@Service   
public class CourseAccessService {
    private final CourseAccessRepository courseAccessRepository;
    public CourseAccessService(CourseAccessRepository courseAccessRepository) {
        this.courseAccessRepository = courseAccessRepository;
    }
    public List<CourseAccess> getCourseAccess() {
        return courseAccessRepository.findAll();
    }

}
