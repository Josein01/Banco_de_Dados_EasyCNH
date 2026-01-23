package com.example.demo.InstructorReview;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class InstructorReviewService {
    private final InstructorReviewRepository instructorReviewRepository;
    public InstructorReviewService(InstructorReviewRepository instructorReviewRepository) {
        this.instructorReviewRepository = instructorReviewRepository;
    }
    public List<InstructorReview> getInstructorReviews() {
        return instructorReviewRepository.findAll();
    }

}