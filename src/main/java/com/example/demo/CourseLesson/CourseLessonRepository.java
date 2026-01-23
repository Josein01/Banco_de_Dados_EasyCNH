package com.example.demo.CourseLesson;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CourseLessonRepository extends JpaRepository<CourseLesson, Long>{

}
