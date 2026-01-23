package com.example.demo.InstructorReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorReviewRepository extends JpaRepository <InstructorReview, Long> {

}
