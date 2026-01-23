package com.example.demo.CourseLessonQuiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseLessonQuizRepository extends JpaRepository<CourseLessonQuiz,Long> {

}
